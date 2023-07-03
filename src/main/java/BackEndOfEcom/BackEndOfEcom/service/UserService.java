package BackEndOfEcom.BackEndOfEcom.service;

import BackEndOfEcom.BackEndOfEcom.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User createUser(User user);

    public User getUserById(Long uId);

    public List<User> getAllUser();

    public User updateUser(User user);

    public void deleteUser(long uId);
}
