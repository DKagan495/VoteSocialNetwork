package by.kagan.votessocialnetwork.DAOs;

import by.kagan.votessocialnetwork.Models.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
@Component
public class UserDAO {
    private boolean isUserLogSuccessful = false;
    private String URL;
    private String USERNAME, PASSWORD;
    private static int LOG_ID = 1;
    private int loginId;
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
    public List<User> showUserList(){
        return userList;
    }
    public boolean tryToLogInAccount(User user){
        for(int i = 0; i < LOG_ID; i++){
            if(userList.get(i).getEmail().equals(user.getEmail()) && userList.get(i).getPassword().equals(user.getPassword())) {
                isUserLogSuccessful = true;
                loginId = LOG_ID;
                break;
            }
            else
                isUserLogSuccessful = false;
        }
        return isUserLogSuccessful;
    }
    public User showUserPage(int id){
        return userList.get(id-1);
    }
    public User showMyPage(){
        return userList.get(loginId-1);
    }
}
