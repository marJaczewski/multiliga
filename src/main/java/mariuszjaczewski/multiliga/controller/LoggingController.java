package mariuszjaczewski.multiliga.controller;


import mariuszjaczewski.multiliga.model.User;
import mariuszjaczewski.multiliga.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class LoggingController {


    @Autowired
    private final UserRepository userRepository;

    public LoggingController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "logging/{email}/{password}" ,method = RequestMethod.GET)
    public List<User> logging (@PathVariable("email")String email, @PathVariable("password")String password){
List<User> message = new ArrayList<>();

User user = userRepository.getByEmailAndHaslo(email, password);

if (user!=null){
    message.add(user);
    return  message;
}else{
    User user1 = new User();
    message.add(user1);
    return message;
}

    }

}
