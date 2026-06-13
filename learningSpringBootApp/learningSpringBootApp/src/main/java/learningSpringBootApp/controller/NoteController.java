package learningSpringBootApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learningSpringBootApp.entity.Note;
import learningSpringBootApp.service.NoteService;

@RestController
@RequestMapping("/notes")
public class NoteController {

  @Autowired
  private NoteService noteService;

  @PostMapping()
  public String saveNotes(@RequestBody Note n) {
    noteService.saveNotes(n);
    return "Note saved successfully";
  }

  @GetMapping
  public List<Note> getAllNotes() {
    return noteService.getAllNotes();
  }

  @GetMapping("/id/{myId}")
  public ResponseEntity<?> getNoteById(@PathVariable String myId) {
    try {
      Optional<Note> note = noteService.getNoteById(myId);

      if (note.isPresent()) {
        return ResponseEntity.ok(note.get());
      }
      return ResponseEntity.notFound().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteNote(@PathVariable String id) {

    noteService.deleteNoteById(id);

    return ResponseEntity.ok("Note deleted successfully");
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateNote(
      @PathVariable String id,
      @RequestBody Note note) {

    boolean updated = noteService.updateNote(id, note);

    if (updated) {
      return ResponseEntity.ok("Note updated successfully");
    }

    return ResponseEntity.notFound().build();
  }

}
