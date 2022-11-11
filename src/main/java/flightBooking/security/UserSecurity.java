/*package flightBooking.security;

import flightBooking.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("userSecurity")
public class UserSecurity {
    @Autowired
    PassengerService passengerService;

    public boolean hasUserId(Authentication authentication, Integer userId) {

        int userID= (int) passengerService.findByUserName(authentication.getName()).getPassengerId();
        if(userID==userId)
            return true;

        return false;

    }
}*/

