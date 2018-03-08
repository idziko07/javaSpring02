package pl.javaspring.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @RequestMapping("/users")
    @ResponseBody
    public String showInfoUsers(){
        List<User> users = this.userRepository.getUsers();

        String results = "";
        for (User user : users) {
            results += user + "<br>";
        }
        return results;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser(@RequestParam(value = "name",required = false, defaultValue = "Anonim") String name,@RequestParam String surname,@RequestParam Integer age){
        User user = new User(name,surname,age);
        this.userRepository.add(user);
        return "redirect:/success.html";
    }
}
