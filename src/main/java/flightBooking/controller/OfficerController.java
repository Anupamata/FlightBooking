package flightBooking.controller;

import flightBooking.model.BookedTickets;
import flightBooking.model.FlightDetails;
import flightBooking.model.Officer;
import flightBooking.model.Passenger;
import flightBooking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/officer")
public class OfficerController {
    @Autowired
    private OfficerService officerService;
    @Autowired
    private PassengerService passengerService;

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
        List<FlightDetails> flightDetailsList=flightDetailsService.fetchAllFlightDetails();
        modelAndView.addObject("flightDetailsList" , flightDetailsList);
        modelAndView.addObject("flightDetails" , new FlightDetails());
        return modelAndView;
    }
    @RequestMapping("/listOfPassengers")
    public ModelAndView listOfPassengers(@RequestParam long  id) {
        ModelAndView mav = new ModelAndView("listOfPassengers");
        ArrayList<Passenger> passengerDetailsList = new ArrayList<>();
        List <BookedTickets> bookedTicketList =bookingService.getBookingByFlightId(id);
        for(BookedTickets bookedTickets:bookedTicketList)
        {
            Passenger passengerDetails = passengerService.getPassengerById(bookedTickets.getPassengerId());
            passengerDetailsList.add(passengerDetails);
        } List<Passenger> passengerDetailsListS = passengerDetailsList
                .stream()
                .distinct()
                .collect(Collectors.toList());
        mav.addObject("passengerDetailsList",passengerDetailsListS);
        mav.addObject("passenger",new Passenger());
        mav.addObject("bookedDetails",bookedTicketList);
        mav.addObject("bookedTickets",new BookedTickets());
        return mav;
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
        flightDetailsService.insertFlight(flightDetails);
        return mv;
    }
}

