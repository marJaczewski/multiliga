package mariuszjaczewski.multiliga.controller;


import mariuszjaczewski.multiliga.model.Dyscypline;
import mariuszjaczewski.multiliga.model.Race;
import mariuszjaczewski.multiliga.model.Team;
import mariuszjaczewski.multiliga.model.User;
import mariuszjaczewski.multiliga.repository.DyscyplineRepository;
import mariuszjaczewski.multiliga.repository.RaceRepository;
import mariuszjaczewski.multiliga.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

@RestController
@RequestMapping("/race")
public class RaceController {

    @Autowired
    private final RaceRepository raceRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final DyscyplineRepository dyscyplineRepository;


    public RaceController(RaceRepository raceRepository, UserRepository userRepository, DyscyplineRepository dyscyplineRepository) {
        this.raceRepository = raceRepository;
        this.userRepository = userRepository;
        this.dyscyplineRepository = dyscyplineRepository;
    }


    @RequestMapping(value = "/createNewRace/{type}/{capacity}/{date}/{distance}/{place}", method = RequestMethod.GET)
    public List<String> createNewRace(
            @PathVariable("type")String type,
            @PathVariable("capacity") Long capacity,
            @PathVariable("date")String date,
            @PathVariable("distance") int distance,
            @PathVariable("place") String place){

        Dyscypline dyscypline = dyscyplineRepository.getOneByName(type);

        raceRepository.save(new Race(dyscypline,capacity, date, distance,place));

        List<String> message = new ArrayList<>();

        message.add("Dodano nowy wyscig.");

        return message;

    }


    @RequestMapping(value = "/getAllRaces", method = RequestMethod.GET)
    public List<Race> getAllRaces(){

                List<Race> races;
                List<Race> availableRaces = new ArrayList<>();
               races = raceRepository.findAll();

               for (int i = 0 ;i<races.size(); i++ ){

                   if(races.get(i).getUsers().size()<=races.get(i).getcapacity()){

                   availableRaces.add(races.get(i));
                   }

               }
               return availableRaces;
    }

@RequestMapping(value = "/signIntoRace/{userId}/{raceId}", method = RequestMethod.GET)
    public List<String> signIntoRace(@PathVariable("userId")Long userId, @PathVariable("raceId")Long raceId){



raceRepository.setRaceMember(userId, raceId);


    List <String>message = new ArrayList<>();
    message.add("Zapisałeś się na wyścig.");

return message;
    }





}
