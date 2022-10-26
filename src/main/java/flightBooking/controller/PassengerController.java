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
    @RequestMapping("/fetchPassengerById/{id}")
    public ModelAndView searchPassengerById(@PathVariable long  id) {
        ModelAndView mav = new ModelAndView("singlePassengerDetails");
        Passenger passenger = passengerService.getPersonById(id);
        mav.addObject("passenger", passenger);
        Address address = addressService.getAddressById(passenger.getIdAddress());
        mav.addObject("address", address);
       /* BookedTickets bookedTickets = bookingService.getBookingByPassengerId(id);
        mav.addObject("bookedTickets", bookedTickets);*/
        return mav;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editCustomerDetails(@PathVariable long  id) {
        ModelAndView mav = new ModelAndView("editPassenger");
        Passenger passenger = passengerService.getPersonById(id);
        List<BookedTickets> bookedDetailsList=bookingService.getBookingByPassengerId(id);
        mav.addObject("bookedDetails", bookedDetailsList);
        mav.addObject("bookedTickets", new BookedTickets());
        mav.addObject("passenger", passenger);
        /*BookedTickets bookedTickets = bookingService.getBookingByPassengerId(id);
        mav.addObject("bookedTickets", bookedTickets);*/

        return mav;
    }
    @RequestMapping("/editAddress")
    public ModelAndView editAddressDetails(@RequestParam long  id) {
        ModelAndView mav = new ModelAndView("editAddress");
        Address address = addressService.getAddressById(id);
        mav.addObject("address", address);
        return mav;
    }
    @RequestMapping("/bookedTicket")
    public ModelAndView seeBookedTicket(@RequestParam long  id) {
        ModelAndView mav = new ModelAndView("BookedFlightDetails");
        List<BookedTickets> bookedDetailsList= bookingService.getBookingByPassengerId(id);
        mav.addObject("bookedDetails",bookedDetailsList);
        mav.addObject("bookedTickets",new BookedTickets());
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
        List<FlightDetails> flightDetailsList = flightDetailsService.fetchAllAvailableFlight();
        ModelAndView mav = new ModelAndView("listOfAllFlight");
        mav.addObject("flightDetails", new FlightDetails());
        mav.addObject("flightDetailsList", flightDetailsList);
        Passenger passenger=passengerService.getPersonById(passengerId);
        mav.addObject("passenger", passenger);

        return mav;
    }
    @RequestMapping("/bookTicket/{passengerId}/{flightId}")
    public ModelAndView bookTicket(@PathVariable long passengerId,@PathVariable long  flightId) {
        ModelAndView mav = new ModelAndView("bookFlight");
        BookedTickets bookedTickets=new BookedTickets();
        bookedTickets.setPassengerId(passengerId);
        bookedTickets.setFlightId(flightId);
        mav.addObject("newBookedTicket",bookedTickets);
        return mav;
    }
    @RequestMapping("/newTicket/{flightId}")
    public ModelAndView bookedTicket(@ModelAttribute("newBookedTicket") BookedTickets bookedTickets,@PathVariable long flightId) {
        ModelAndView mav = new ModelAndView("BookedFlightDetails");
        FlightDetails flightDetails=flightDetailsService.getPersonById(flightId);
        bookedTickets.setPrice(flightDetails.getPrice()*bookedTickets.getSeatsReserved());
       BookedTickets bookedTicket=bookingService.insertPerson(bookedTickets);
       long passengerId=bookedTicket.getPassengerId();
       List<BookedTickets> bookedDetailsList= bookingService.getBookingByPassengerId(passengerId);
       FlightDetails bookedFlight=flightDetails;
       bookedFlight.setSeats((flightDetails.getSeats()-bookedTickets.getSeatsReserved()));
       flightDetailsService.insertPerson(bookedFlight);
        mav.addObject("bookedDetails",bookedDetailsList);
        mav.addObject("bookedTickets",new BookedTickets());
        return mav;
    }
    @RequestMapping (value = "/cancel/{passengerId}")
    public ModelAndView cancelTicket(@PathVariable long passengerId) {
        ModelAndView modelAndView =  new ModelAndView("cancelTicket");
        List<BookedTickets> bookedDetailsList= bookingService.getBookingByPassengerId(passengerId);
        modelAndView.addObject("bookedDetails",bookedDetailsList);
        modelAndView.addObject("bookedTickets",new BookedTickets());
        return modelAndView;
    }
    @RequestMapping(value = "/cancelTicket/{bookingId}")
    public ModelAndView cancelBookedTicket(@PathVariable long bookingId) {
        ModelAndView modelAndView =  new ModelAndView("cancelled");
        BookedTickets bookedTicket=bookingService.getPersonById(bookingId);
        long flightId=bookedTicket.getFlightId();
       long seats=bookedTicket.getSeatsReserved();
       FlightDetails flightDetails=flightDetailsService.getPersonById(flightId);
       flightDetails.setSeats((flightDetails.getSeats()+seats));
       flightDetailsService.insertPerson(flightDetails);
       bookingService.deleteById(bookingId);
        return modelAndView;
    }


}
