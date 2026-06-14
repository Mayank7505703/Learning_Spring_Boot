package learningSpringBootApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learningSpringBootApp.entity.User;
import learningSpringBootApp.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public boolean saveUser(User user) {
    User existingUser = userRepository.findByUserName(user.getUserName());
    if (existingUser != null) {
      return false;
    }
    userRepository.save(user);
    return true;
  }

  public List<User> getAllUser() {
    return userRepository.findAll();
  }

  public User getUserByUsername(String username) {
    return userRepository.findByUserName(username);
  }

  public boolean updateUser(String username, User newUser){

    User oldUser = userRepository.findByUserName(username);

    if(oldUser == null){
        return false;
    }

    if(newUser.getName() != null){
        oldUser.setName(newUser.getName());
    }

    if(newUser.getPassword() != null){
        oldUser.setPassword(newUser.getPassword());
    }

    userRepository.save(oldUser);
    return true;
  }
}
