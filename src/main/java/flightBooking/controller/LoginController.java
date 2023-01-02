package flightBooking.controller;

import flightBooking.model.Passenger;
import flightBooking.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Objects;

@RestController
public class LoginController {
    @Autowired
    PassengerService passengerService;
    @RequestMapping("/services")
    public ModelAndView hello(ModelMap model, Principal principal) {

        String loggedInUserName=principal.getName();
        Passenger passenger=passengerService.getPassengerByUserName(loggedInUserName);
        if(Objects.equals(passenger.getRole(), "ROLE_USER")) {
            ModelAndView modelAndView = new ModelAndView("servicesOfPassenger", "username", loggedInUserName);
            modelAndView.addObject("passenger", passenger);
            return modelAndView;
        }
        else {
            ModelAndView modelAndView = new ModelAndView("servicesOfOfficer", "username", loggedInUserName);
            modelAndView.addObject("passenger", passenger);
            return modelAndView;
        }
    }

    @RequestMapping(value="/loginError", method = RequestMethod.GET)
    public ModelAndView loginError(ModelMap model) {
        return new ModelAndView("loginError");
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


    @GetMapping("/session")
    public String sessionExpired(Model model) {
        model.addAttribute("errorMessage", "Your session has expired. Please log in again.");
        return "login";
    }
}
