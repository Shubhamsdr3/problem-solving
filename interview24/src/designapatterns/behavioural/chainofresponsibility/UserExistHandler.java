package designapatterns.behavioural.chainofresponsibility;

public class UserExistHandler extends Handler {

    private Database database;

    public UserExistHandler(Database database) {
        this.database = database;
    }

    @Override
    public boolean handle(String userName, String password) {
        if (!database.isValidUser(userName)) {
            return false;
        }
        return handleNext(userName, password);
    }
}
