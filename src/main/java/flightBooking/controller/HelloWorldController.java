package flightBooking.controller;

import flightBooking.model.Passenger;
import flightBooking.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
@RestController
public class HelloWorldController {
    @Autowired
    PassengerService passengerService;
    @RequestMapping("/helloworld")
    public ModelAndView hello(ModelMap model, Principal principal) {

        String loggedInUserName=principal.getName();
        Passenger passenger=passengerService.getPassengerByUserName(loggedInUserName);
        ModelAndView modelAndView=new ModelAndView("hello", "username", loggedInUserName);
        modelAndView.addObject("passenger",passenger);
        return modelAndView;
    }

    @RequestMapping("/admin")
    public ModelAndView helloAdmin(ModelMap model,Principal principal) {

        String loggedInUserName=principal.getName();
        Passenger passenger=passengerService.getPassengerByUserName(loggedInUserName);
        ModelAndView modelAndView=new ModelAndView("admin", "username", loggedInUserName);
        modelAndView.addObject("passenger",passenger);
        return modelAndView;
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login(ModelMap model) {

        return new ModelAndView("login");

    }

    @RequestMapping(value="/loginError", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";
    }

    // for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied(Principal user) {

        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("msg", "Hi " + user.getName()
                    + ", You can not access this page!");
        } else {
            model.addObject("msg",
                    "You can not access this page!");
        }

        model.setViewName("403");
        return model;
    }


}
