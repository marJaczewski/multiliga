package mariuszjaczewski.multiliga.controller;


import mariuszjaczewski.multiliga.model.Dyscypline;
import mariuszjaczewski.multiliga.repository.DyscyplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;


 @RestController
 @RequestMapping("/user")
public class LoadAllDyscyplinesRestController {

    @Autowired
    private final DyscyplineRepository dyscyplineRepository;

    public LoadAllDyscyplinesRestController(DyscyplineRepository dyscyplineRepository) {
        this.dyscyplineRepository = dyscyplineRepository;
    }

    @RequestMapping(value = "/getAllDyscyplines", method = RequestMethod.GET)
    public List<Dyscypline> getAllDyscyplines(){

     return  dyscyplineRepository.findAll();

//public String gAD(){
//
//
//    return "noElo";

    }




}
