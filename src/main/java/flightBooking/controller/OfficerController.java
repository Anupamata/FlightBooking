package flightBooking.controller;

import flightBooking.model.FlightDetails;
import flightBooking.model.Officer;
import flightBooking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/officer")
public class OfficerController {
    @Autowired
    private OfficerService officerService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private FlightDetailsService flightDetailsService;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView officerLoginForm() {
        ModelAndView modelAndView =  new ModelAndView("officerLogin");
        modelAndView.addObject("officer" , new Officer());
        return modelAndView;
    }
    @RequestMapping(value = "/loginResult",method = RequestMethod.POST)
    public ModelAndView officerValidation(@ModelAttribute("officer") Officer officer) {
        Officer newOfficer=officerService.login(officer.getUsername(),officer.getPassword());
        if(newOfficer==null)
        {
            return new ModelAndView("officerError");
        }
        else
        {
            ModelAndView modelAndView =  new ModelAndView("servicesOfOfficer");
            modelAndView.addObject("officer" , newOfficer);
            return modelAndView;
        }
    }
    @RequestMapping(value = "/flightList",method = RequestMethod.GET)
    public ModelAndView flightList() {
        ModelAndView modelAndView =  new ModelAndView("flightList");
        List<FlightDetails> flightDetailsList=flightDetailsService.fetchAllPerson();
        modelAndView.addObject("flightDetailsList" , flightDetailsList);
        modelAndView.addObject("flightDetails" , new FlightDetails());
        return modelAndView;
    }
    @RequestMapping("/addFlight")
    public ModelAndView addNewFlight() {
        ModelAndView modelAndView =  new ModelAndView("addNewFlight");
        FlightDetails flightDetails=new FlightDetails();
        modelAndView.addObject("flightDetails" , flightDetails);
        return modelAndView;
    }
    @RequestMapping(value = "/saveFlight", method = RequestMethod.POST)
    public ModelAndView saveFlight(@ModelAttribute("flightDetails") FlightDetails flightDetails) {
        ModelAndView mv =  new ModelAndView("successPage");
        flightDetailsService.insertPerson(flightDetails);
        return mv;
    }
}
