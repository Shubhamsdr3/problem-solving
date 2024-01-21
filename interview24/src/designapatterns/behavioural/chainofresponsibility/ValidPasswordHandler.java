package designapatterns.behavioural.chainofresponsibility;

public class ValidPasswordHandler extends Handler {

    private Database database;

    public ValidPasswordHandler(Database database) {
        this.database = database;
    }

    @Override
    public boolean handle(String userName, String password) {
        return database.isValidPassword(userName, password);
    }
}
