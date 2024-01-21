package designapatterns.behavioural.chainofresponsibility;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private final Map<String, String> users = new HashMap<>();

    public Database() {
        users.put("admin_username", "admin_password");
        users.put("user_username", "user_password");
    }

    public boolean isValidUser(String userName) {
        return users.containsKey(userName);
    }

    public boolean isValidPassword(String userName, String password) {
        return users.get(userName).equals(password);
    }
}
