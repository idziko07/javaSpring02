package pl.javaspring.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    List<User> users;

    public UserRepository(){
        this.users = new ArrayList<>();
        users.add(new User("Dawid","Krawczyk",40));
        users.add(new User("Agnieszka","Maj",20));
        users.add(new User("Danuta","Kowalska",55));
    }

    public List<User> getUsers() {
        return users;
    }
    public void add(User user){
       this.users.add(user);
    }

}
