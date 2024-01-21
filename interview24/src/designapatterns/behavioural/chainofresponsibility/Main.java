package designapatterns.behavioural.chainofresponsibility;

public class Main {

    public static void main(String[] args) {
        Database database = new Database();
        Handler handler = new UserExistHandler(database)
                .setNextHandler(new RoleCheckHandler(database))
                .setNextHandler(new RoleCheckHandler(database));

        AuthService service = new AuthService(handler);
        service.logIn("username", "password");
    }
}
