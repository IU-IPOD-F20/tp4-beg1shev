package application.action;

import application.action.actioncontext.ApplicationContextBankAgency;
import bank.Account;
import bank.BankAgency;

import java.io.PrintStream;
import java.util.Scanner;

public class ActionOwnerAccounts implements Action<ApplicationContextBankAgency> {
    private String message;
    private String code;

    public ActionOwnerAccounts(String code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String actionCode() {
        return this.code;
    }

    @Override
    public String actionMessage() {
        return this.message;
    }

    @Override
    public void execute(ApplicationContextBankAgency appcontext) throws Exception {
        BankAgency ag = appcontext.getBankAgency();
        PrintStream printStream = appcontext.getPrintStream();
        Scanner scanner = appcontext.getScanner();
        printStream.print("Owner name -> ");
        String ownerName = scanner.nextLine();
        ownerAccounts(ag, ownerName);

    }

    public static void ownerAccounts(BankAgency ag, String ownerName){
        Account[]  t;
        t = ag.getAccountsOf(ownerName);
        if (t.length == 0) {
            System.out.println("no account on this name ...");
        } else {
            System.out.println("  " + t.length + " accounts for " + ownerName);
            for (int i=0; i<t.length; i++)
                t[i].print();
        }
    }
}
