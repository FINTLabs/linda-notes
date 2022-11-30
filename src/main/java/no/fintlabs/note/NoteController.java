package no.fintlabs.note;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/notes")
public class NoteController {
    private final NoteRepository repository;

    public NoteController(NoteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        log.debug("Adding note with is {}", note.getId());

        repository.addOrUpdate(note);

        return ResponseEntity.ok(note);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAll() {
        return ResponseEntity.ok(repository.getNotes());
    }
}
