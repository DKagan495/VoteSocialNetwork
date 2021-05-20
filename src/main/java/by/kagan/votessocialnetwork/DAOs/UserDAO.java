package by.kagan.votessocialnetwork.DAOs;

import by.kagan.votessocialnetwork.Models.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
@Component
public class UserDAO {
    private boolean isUserLogSuccessful = false;
    private String URL;
    private String USERNAME, PASSWORD;
    private static int LOG_ID = 1;
    private static int loginId;
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
    public boolean tryToLogInAccount(User user, HttpSession httpSession){
        for(int i = 0; i < LOG_ID; i++){
            if(userList.get(i).getEmail().equals(user.getEmail()) && userList.get(i).getPassword().equals(user.getPassword())) {
                isUserLogSuccessful = true;
                httpSession.setAttribute("loginId", i);
                loginId = (int)httpSession.getAttribute("loginId");
                System.out.println(loginId);
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
        return userList.get(loginId);
    }
    public void logOut(){
        isUserLogSuccessful = false;
        loginId = 0;
    }
}
