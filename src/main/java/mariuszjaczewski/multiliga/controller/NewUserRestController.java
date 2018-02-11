package mariuszjaczewski.multiliga.controller;


import mariuszjaczewski.multiliga.entity.api.UserDto;
import mariuszjaczewski.multiliga.model.User;
import mariuszjaczewski.multiliga.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class NewUserRestController {

    @Autowired
    private final UserRepository userRepository;

    public NewUserRestController(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @RequestMapping("/free/newUser")
    public void newUser(@RequestBody UserDto userDto){

        User user = new User(userDto.getNazwisko(),userDto.getEmail(), userDto.getHaslo(),"user");

        System.err.println("DodanoUzytkownika: "+userDto.toString());
        userRepository.save(user);



    }



}
