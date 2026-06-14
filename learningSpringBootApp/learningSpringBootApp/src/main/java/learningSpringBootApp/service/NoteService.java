package learningSpringBootApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import learningSpringBootApp.entity.Note;
import learningSpringBootApp.entity.User;
import learningSpringBootApp.repository.NoteRepository;
import learningSpringBootApp.repository.UserRepository;
@RestController
public class NoteService {

  @Autowired
  private NoteRepository noteRepository;
  
  @Autowired
  private UserRepository userRepository;

  public boolean saveNotes(Note n , String userName) {
   User user = userRepository.findByUserName(userName);
    if(user==null){
      return false;
    }
    Note savedNote=noteRepository.save(n);
    user.getNote().add(savedNote);
    userRepository.save(user);
    return true;
  }

  public List<Note> getAllNotes() {
    return noteRepository.findAll();
  }

  public Optional<Note> getNoteById(String id) {
    return noteRepository.findById(id);
  }

  public void deleteNoteById(String id) {
    noteRepository.deleteById(id);
  }

  public boolean updateNote(String id, Note newNote) {

    Optional<Note> oldNote = noteRepository.findById(id);

    if (oldNote.isPresent()) {

      Note note = oldNote.get();

      note.setTitle(newNote.getTitle());
      note.setContent(newNote.getContent());

      noteRepository.save(note);

      return true;
    }

    return false;
  }
}
