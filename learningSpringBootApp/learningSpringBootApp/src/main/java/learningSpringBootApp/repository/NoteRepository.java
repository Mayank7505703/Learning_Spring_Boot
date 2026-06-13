package learningSpringBootApp.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RestController;

import learningSpringBootApp.entity.Note;

@RestController
public interface NoteRepository extends MongoRepository<Note, String> {

}
