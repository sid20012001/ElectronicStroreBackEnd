package BackEndOfEcom.BackEndOfEcom.Controller;


import BackEndOfEcom.BackEndOfEcom.Entity.User;
import BackEndOfEcom.BackEndOfEcom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/create-user")
    public User createUser(@RequestBody User user) {

        user.setRole("Normal");
        user.setPassword((bCryptPasswordEncoder.encode(user.getPassword())));
       return this.userService.createUser(user);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return this.userService.getUserById(userId);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return this.userService.getAllUser();
    }

    @PutMapping("/user/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
       return this.userService.updateUser(updatedUser);
    }

    @DeleteMapping("/delete-user/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        this.userService.deleteUser(userId);

    }
}
