package com.example.mindassistantapi.controllers;

import com.example.mindassistantapi.models.Label;
import com.example.mindassistantapi.models.Note;
import com.example.mindassistantapi.services.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(
        origins = {"http://localhost:3000", "https://mind-assistant.herokuapp.com/"},
        allowCredentials = "true"
)
public class NoteController {
    @Autowired
    NoteService service;

    @GetMapping("/api/notes")
    public List<Note> findAllNotes(){
        return service.findAllNotes();
    }

    @GetMapping("/api/notes/{uid}")
    public Note findNoteById(@PathVariable("uid") int noteId){
        return service.findNoteById(noteId);
    }

    @GetMapping("/api/users/{uid}/notes")
    public List<Note> findNotesByUser(@PathVariable("uid") int userId){
        return service.findNotesByUser(userId);
    }

    @PostMapping("/api/users/{uid}/notes")
    public Note createNoteForUser(@PathVariable("uid") int userId, @RequestBody Note newNote){
        return service.createNoteForUser(userId, newNote);
    }

    @GetMapping("/api/folders/{fid}/notes")
    public List<Note> findNotesByFolder(@PathVariable("fid") int folderId){
        return service.findNotesByFolder(folderId);
    }

    @PostMapping("/api/folders/{fid}/notes")
    public Note createNoteForFolder(@PathVariable("fid") int folderId, @RequestBody Note newNote){
        return service.createNoteForFolder(folderId, newNote);
    }

    @PutMapping("/api/notes/{fid}")
    public int updateNote(@PathVariable("fid") int noteId, @RequestBody Note updated){
        return service.updateNote(noteId, updated);
    }

    @DeleteMapping("/api/notes/{fid}")
    public int deleteNote(@PathVariable("fid") int noteId){
        return service.deleteNote(noteId);
    }

    // SEARCH FOR NOTE
    // api/notes/search?note=criteria
    @RequestMapping("api/notes/search")
    public List<Note> searchForNote(@RequestParam Optional<String> note) {
        return service.searchForNote(note.orElse("_"));
    }

    @GetMapping("/api/notes/{nid}/labels")
    public List<Label> findLabelsForNote(@PathVariable("nid") int noteId){
        return service.findLabelsByNoteId(noteId);
    }

}
