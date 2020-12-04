package application.action;

import application.action.actioncontext.ApplicationContextBankAgency;
import bank.BankAgency;
import bank.exception.ABInexistingAccountException;

import java.io.PrintStream;
import java.util.Scanner;

public class ActionDeleteAccount implements Action<ApplicationContextBankAgency> {
    private String message;
    private String code;

    public ActionDeleteAccount(String code, String message) {
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
    public void execute(ApplicationContextBankAgency context) throws Exception {
        Scanner scanner = context.getScanner();
        PrintStream printStream = context.getPrintStream();
        BankAgency ag = context.getBankAgency();
        printStream.print("Account Number -> ");
        String number = scanner.next();
        try {
            ag.removeAccount(number);
        } catch (ABInexistingAccountException e) {
            printStream.println(e.toString());
        }
    }
}