package application.action;

import application.action.actioncontext.ApplicationContextBankAgency;
import bank.Account;
import bank.BankAgency;
import bank.exception.AccountException;

import java.io.PrintStream;
import java.util.Scanner;

public class ActionWithdrawFromAccount implements Action<ApplicationContextBankAgency> {
    String message;
    String code;

    public ActionWithdrawFromAccount(String code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String actionMessage() {
        return this.message;
    }

    @Override
    public String actionCode() {
        return this.code;
    }

    @Override
    public void execute(ApplicationContextBankAgency appcontext) throws Exception {
        PrintStream printStream = appcontext.getPrintStream();
        Scanner scanner = appcontext.getScanner();
        BankAgency ag = appcontext.getBankAgency();
        printStream.print("Account Number -> ");
        String number = scanner.next();
        printStream.print("Withdraw amount -> ");
        double amount = scanner.nextDouble();
        withdrawFromAccount(ag, number, amount, printStream);
    }

    private static void withdrawFromAccount(BankAgency ag, String accountNumber, double amount, PrintStream printStream) {
        Account c;

        c = ag.getAccount(accountNumber);
        if (c==null) {
            printStream.println("Account not existing ...");
        } else {
            printStream.println("Balance before withdrawal: " + c.balance());
            try {
                c.withdraw(amount);
                printStream.println("Balance after withdrawal: "+c.balance());
            } catch (AccountException e) {
                printStream.println("Withdraw error, Balance unchanged: " + c.balance());
                printStream.println(e.getMessage());
            }
        }

    }
}