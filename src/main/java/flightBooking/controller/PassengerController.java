package flightBooking.controller;

import flightBooking.model.Address;
import flightBooking.model.Passenger;
import flightBooking.service.AddressService;
import flightBooking.service.BookingService;
import flightBooking.service.FlightDetailsService;
import flightBooking.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/passenger")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;
   /* @Autowired
    private AddressService addressService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private FlightDetailsService flightDetailsService;
*/
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
        Address address = addressService.getAddressById(passenger.getAddressId());
        mav.addObject("address", address);
        return mav;
    }
}
