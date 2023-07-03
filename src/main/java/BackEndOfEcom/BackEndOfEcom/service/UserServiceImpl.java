package BackEndOfEcom.BackEndOfEcom.service;

import BackEndOfEcom.BackEndOfEcom.Entity.User;
import BackEndOfEcom.BackEndOfEcom.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    public UserRepository userRepository;
    @Override
    public User createUser(User user) {
        this.userRepository.save(user);
        return user;
    }

    @Override
    public User getUserById(Long uId) {
        return this.userRepository.findById(uId).get();
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {

        this.userRepository.save(user);
        return user ;
    }

    @Override
    public void deleteUser(long uId) {
        this.userRepository.deleteById(uId);
    }
}
