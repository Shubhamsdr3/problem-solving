package designapatterns.behavioural.chainofresponsibility;

public class RoleCheckHandler extends Handler {

    private Database database;

    public RoleCheckHandler(Database database) {
        this.database = database;
    }

    @Override
    public boolean handle(String userName, String password) {
        if ("admin_username".equals(userName)) {
            //
        }
        System.out.println("Loading default page..");
        return handleNext(userName, password);
    }
}
