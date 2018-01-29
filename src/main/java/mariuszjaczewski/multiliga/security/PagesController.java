package mariuszjaczewski.multiliga.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

//@RestController
@Controller

public class PagesController {


    @GetMapping("/")
    public String index( ) {

        return "index.html";  // return hello jsp
    }



//        @RequestMapping(value = "/", method = GET)
//        String main() {
//            return "";
//        }
//
////        @RequestMapping(value = "/index", method = GET)
////        String index() {
////            return "index.html";
////        }
//
//        @RequestMapping(value = "/admin", method = GET)
//        String admin() {
//            return "admin";
//        }
//
//        @RequestMapping(value = "/logout", method = GET)
//        String logout() {
//            return "logout";
//        }
//
//        @RequestMapping(value = "/bye", method = GET)
//        String bye() {
//            return "bye";
//        }
    }