/*
package flightBooking.service.impl;

import flightBooking.dao.PassengerDao;
import flightBooking.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    PassengerDao passengerDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Passenger user = passengerDao.findByUserName(username);
        if (user == null) throw new UsernameNotFoundException(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet< >();
        List<Passenger> passengerList=new ArrayList<>();
        for(Passenger passenger:passengerList)
        {
            grantedAuthorities.add(new SimpleGrantedAuthority(passenger.getUsername()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
*/
