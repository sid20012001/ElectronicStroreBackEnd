package BackEndOfEcom.BackEndOfEcom.Configuration;

import BackEndOfEcom.BackEndOfEcom.Entity.User;
import BackEndOfEcom.BackEndOfEcom.Repository.UserRepository;
import BackEndOfEcom.BackEndOfEcom.Entity.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CustomUserDetialService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user= this.userRepository.findByUsername(username);

        return user.map(CustomUser::new).orElseThrow(()->new UsernameNotFoundException("user not found"));
    }
}

