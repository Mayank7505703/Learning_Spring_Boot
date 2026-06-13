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
