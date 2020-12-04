package application.action.actioncontext;

import application.AccesBankAgency;
import bank.BankAgency;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ApplicationContextBankAgency implements ApplicationContext {
    private static ApplicationContextBankAgency instance;
    private BankAgency bankAgency;
    private Scanner scanner;
    private PrintStream printStream;

    private ApplicationContextBankAgency(){
        this.printStream = new PrintStream(System.out);
        this.scanner = new Scanner(System.in);
        this.bankAgency = AccesBankAgency.getBankAgency();
    }

    public static ApplicationContextBankAgency getInstance() {
        if(instance == null)
            instance = new ApplicationContextBankAgency();
        return instance;
    }

    public Scanner getScanner(){
        return scanner;
    }

    public PrintStream getPrintStream(){
        return printStream;
    }

    public BankAgency getBankAgency(){
        return bankAgency;
    }

    public void setInputStream(InputStream stream){
        scanner.close();
        scanner = new Scanner(stream);
    }

    public void close(){
        scanner.close();
        printStream.close();
    }
}
