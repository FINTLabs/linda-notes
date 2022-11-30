package no.fintlabs.note;

import no.fintlabs.note.Note;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class NoteRepository {
    private Map<String, Note> notes = new ConcurrentHashMap<>();

    public void addOrUpdate(Note note) {
        notes.put(note.getId(), note);
    }

    public void remove(Note note) {
        notes.remove(note.getId());
    }

    public Note getNote(String noteId) {
        return notes.get(noteId);
    }

    public List<Note> getNotes() {
        return notes
                .values()
                .stream()
                .toList();
    }
}
