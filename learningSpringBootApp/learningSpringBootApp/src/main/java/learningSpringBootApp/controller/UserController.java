package learningSpringBootApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learningSpringBootApp.entity.User;
import learningSpringBootApp.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUser();
  }

  @PostMapping

  public ResponseEntity<?> createUser(@RequestBody User user) {
    boolean created =userService.saveUser(user);
    if(created){
      return ResponseEntity.ok("User created successfully");
    }
    
    return ResponseEntity.badRequest().body("Username already exist");
  }

  @GetMapping("/{userName}")
  public ResponseEntity<?> getUserByUsername(@PathVariable String userName) {
    User user = userService.getUserByUsername(userName);
    if (user != null) {
      return ResponseEntity.ok(user);
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{userName}")
  public ResponseEntity<?> updateUser(@RequestBody User user , @PathVariable String userName){
    boolean update = userService.updateUser(userName, user);
    if(update){
      return ResponseEntity.ok("User updated");
    }
    return ResponseEntity.notFound().build();

  }
}
