package learningSpringBootApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import learningSpringBootApp.entity.Note;

import learningSpringBootApp.repository.NoteRepository;

@RestController
public class NoteService {

  @Autowired
  
  private NoteRepository noteRepository;

  public void saveNotes(Note n) {
    noteRepository.save(n);
  }

  public List<Note> getAllNotes() {
    return noteRepository.findAll();
  }

  public Optional<Note> getNoteById(String id) {
    return noteRepository.findById(id);
  }
}
