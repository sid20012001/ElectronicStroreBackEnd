package BackEndOfEcom.BackEndOfEcom.Controller;

import BackEndOfEcom.BackEndOfEcom.Configuration.CustomUserDetialService;
import BackEndOfEcom.BackEndOfEcom.Entity.User;
import BackEndOfEcom.BackEndOfEcom.Repository.UserRepository;
import BackEndOfEcom.BackEndOfEcom.Utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomUserDetialService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserRepository userRepository;


    @CrossOrigin("*")
    @PostMapping("/generate-token")
    public ResponseToken authenticate(@RequestBody RequestCredentical requestCredentical){
        //here is the code authntication
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestCredentical.getUsername(), requestCredentical.getPassword()));

        // Set the authenticated user in the security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        if (authentication.isAuthenticated()) {
            // Generate a JWT token
            UserDetails userDetails = userDetailsService.loadUserByUsername(requestCredentical.getUsername());
            String jwtToken = jwtUtil.generateToken(userDetails);
            return new ResponseToken(jwtToken);
        }
        else {
            throw new UsernameNotFoundException("User not found");
        }
    }




    @GetMapping("/loggedin-user")
    @CrossOrigin("*")
    public ResponseEntity<String> getCurrentUser(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();

            User user = this.userRepository.findByUsername(username).orElse(null);
            if (user != null) {
                String userData = "{\"userid\": \"" + user.getUid() + "\", \"username\": \"" + user.getUsername() + "\", \"firstname\": \"" + user.getFirstname() + "\", \"lastname\": \"" + user.getLastname() + "\", \"email\": \"" + user.getEmail() + "\", \"mobile\": \"" + user.getMobile() + "\", \"role\": \"" + user.getRole() + "\"}";
                return ResponseEntity.ok(userData);
            }
        }
        return ResponseEntity.notFound().build();
    }


}
