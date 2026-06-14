package learningSpringBootApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import learningSpringBootApp.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUserName(String userName);
}