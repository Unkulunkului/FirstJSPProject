package by.my.storage;

import by.my.model.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStorage {
    private static List<User> userList = new ArrayList<>();
    private static int id = 0;

    public InMemoryStorage(){
        id++;
    }


    public boolean saveUser(User user){
        if(!userList.contains(user)){
            user.setId(id);
            userList.add(user);
            return true;
        }else{
        return false;
        }
    }

    public User getUserByLogin(String login){
        for (User user : userList) {
            if(user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }
    public List<User> getUserList(){
        return userList;
    }

}
