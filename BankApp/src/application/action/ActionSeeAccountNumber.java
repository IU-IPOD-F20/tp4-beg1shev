package application.action;

import application.action.actioncontext.ApplicationContextBankAgency;
import bank.Account;
import bank.BankAgency;

import java.io.PrintStream;
import java.util.Scanner;

public class ActionSeeAccountNumber implements Action<ApplicationContextBankAgency>{
    private String message;
    private String code;

    public ActionSeeAccountNumber(String code, String message) {
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
        PrintStream printStream = appcontext.getPrintStream();
        Scanner scanner = appcontext.getScanner();
        BankAgency ag = appcontext.getBankAgency();
        String number;
        printStream.print("Account Number -> ");
        number = scanner.next();
        Account c = ag.getAccount(number);
        if (c==null) {
            printStream.println("Account non existing ...");
        } else {
            c.print();
        }
    }
}
