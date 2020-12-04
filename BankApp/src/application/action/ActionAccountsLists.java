package application.action;

import application.action.actioncontext.ApplicationContextBankAgency;

public class ActionAccountsLists implements Action<ApplicationContextBankAgency>{
    private String message;
    private String code;

    public ActionAccountsLists(String code, String message) {
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
        appcontext.getBankAgency().print();
    }
}
