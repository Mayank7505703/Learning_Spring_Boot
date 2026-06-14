package learningSpringBootApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import learningSpringBootApp.entity.User;
import learningSpringBootApp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean saveUser(User user) {

        User existingUser = userRepository.findByUserName(user.getUserName());

        if (existingUser != null) {
            return false;
        }

        user.setPassword(
                passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return true;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    public boolean updateUser(String username, User newUser) {

        User oldUser = userRepository.findByUserName(username);

        if (oldUser == null) {
            return false;
        }

        if (newUser.getName() != null) {
            oldUser.setName(newUser.getName());
        }

        if (newUser.getPassword() != null) {
            oldUser.setPassword(
                    passwordEncoder.encode(newUser.getPassword()));
        }

        userRepository.save(oldUser);

        return true;
    }
}