package by.kagan.votessocialnetwork.DAOs;

import by.kagan.votessocialnetwork.Models.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
@Component
public class UserDAO {
    private boolean isUserLogSuccessful;
    private String URL;
    private String USERNAME, PASSWORD;
    private static int LOG_ID = 1;
    private Connection connection;
    private List<User> userList;{
       userList = new ArrayList<>();
       userList.add(new User("Daniel", "Kagan", "Alex", 15, "BSU", "Nnnooot", "emal", "pssewrd"));
    }
    public void addUserToDatabase(User user){
        user.setId(LOG_ID);
        userList.add(user);
        LOG_ID++;
    }
    public List showUserList(){
        return userList;
    }
}
