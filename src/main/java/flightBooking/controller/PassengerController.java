package flightBooking.controller;

import flightBooking.model.Address;
import flightBooking.model.BookedTickets;
import flightBooking.model.FlightDetails;
import flightBooking.model.Passenger;
import flightBooking.service.AddressService;
import flightBooking.service.BookingService;
import flightBooking.service.FlightDetailsService;
import flightBooking.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/passenger")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;
     @Autowired
    private AddressService addressService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private FlightDetailsService flightDetailsService;

    @GetMapping(value = "/login")
    public ModelAndView passengerLogin() {
        ModelAndView modelAndView =  new ModelAndView("passengerLogin");
        modelAndView.addObject("passenger" , new Passenger());
        return modelAndView;
    }
    @PostMapping(value = "/loginResult")
    public ModelAndView newPassengerValidation(@ModelAttribute("passenger") Passenger passenger) {
        Passenger newPassenger =passengerService.login(passenger.getUsername(),passenger.getPassword());
        if(newPassenger ==null)
        {
            return new ModelAndView("passengerLoginError");
        }
        else
        {

            ModelAndView modelAndView =  new ModelAndView("servicesOfPassenger");
            modelAndView.addObject("passenger" , newPassenger);
            return modelAndView;

        }
    }
    @RequestMapping("/fetchById/{id}")
    public ModelAndView searchPassengerById(@PathVariable long  id) {
        ModelAndView mav = new ModelAndView("singlePassengerDetails");
        Passenger passenger = passengerService.getPersonById(id);
        mav.addObject("passenger", passenger);
        Address address = addressService.getAddressById(passenger.getIdAddress());
        mav.addObject("address", address);
        BookedTickets bookedTickets = bookingService.getBookingByPassengerId(id);
        mav.addObject("bookedTickets", bookedTickets);

        return mav;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editCustomerDetails(@PathVariable long  id) {
        ModelAndView mav = new ModelAndView("editPassenger");
        Passenger passenger = passengerService.getPersonById(id);
        mav.addObject("passenger", passenger);
        BookedTickets bookedTickets = bookingService.getBookingByPassengerId(id);
        mav.addObject("bookedTickets", bookedTickets);

        return mav;
    }
    @RequestMapping("/editAddress")
    public ModelAndView editAddressDetails(@RequestParam long  id) {
        ModelAndView mav = new ModelAndView("editAddress");
        Address address = addressService.getAddressById(id);
        mav.addObject("address", address);
        return mav;
    }
    @PostMapping(value = "/passengerSave")
    public ModelAndView saveEditedCustomer(@ModelAttribute("passenger") Passenger passenger) {
        ModelAndView mv =  new ModelAndView("successPage");
        passengerService.insertPerson(passenger);
        return mv;
    }

    @PostMapping(value = "/saveAddress")
    public ModelAndView saveEditedAddress(@ModelAttribute("address") Address address) {
        ModelAndView mv =  new ModelAndView("successPage");
        addressService.insertNewAddress(address);
        return mv;
    }
    @RequestMapping("/fetchById")
    public ModelAndView fetchPassengerById() {
        ModelAndView modelAndView =  new ModelAndView("searchFlight");
        modelAndView.addObject("flightDetails", new FlightDetails());
        return modelAndView;
    }
    @RequestMapping("/searchResult")
    public ModelAndView searchResult(@RequestParam long  id) {
        try {
            ModelAndView mav = new ModelAndView("singleFlightDetails");
            FlightDetails flightDetails = flightDetailsService.getPersonById(id);
            if(flightDetails.getFlightName().equals(null))
            {
                throw new NullPointerException();
            }
            mav.addObject("flightDetails", flightDetails);
            return mav;
        } catch (NullPointerException e) {
            return(new ModelAndView("flightNotPresentError"));
        }
    }
    @RequestMapping(value="/availableTickets/{passengerId}", headers = "Accept=application/json")
    public ModelAndView allWithEdit(@PathVariable long passengerId) {
        List<FlightDetails> flightDetailsList = flightDetailsService.fetchAllPerson();
        ModelAndView mav = new ModelAndView("listOfAllFlightBook");
        mav.addObject("flightDetails", new FlightDetails());
        mav.addObject("flightDetailsList", flightDetailsList);
        Passenger passenger=passengerService.getPersonById(passengerId);
        mav.addObject("passenger", passenger);

        return mav;
    }
    @RequestMapping("/bookTicket/{passengerId}")
    public ModelAndView bookTicket(@PathVariable long passengerId,@RequestParam long  flightId) {
        ModelAndView mav = new ModelAndView("bookFlight");
        BookedTickets bookedTickets=new BookedTickets();
        bookedTickets.setPassengerId(passengerId);
        bookedTickets.setFlightId(flightId);
        BookedTickets newBookedTicket= bookingService.insertPerson(bookedTickets);
        mav.addObject("newBookedTicket",newBookedTicket);
        return mav;
    }

}
