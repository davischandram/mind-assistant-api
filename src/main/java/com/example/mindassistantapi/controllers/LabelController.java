package com.example.mindassistantapi.controllers;

import com.example.mindassistantapi.models.Label;
import com.example.mindassistantapi.models.Note;
import com.example.mindassistantapi.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(
        origins = {"http://localhost:3000", "https://mind-assistant.herokuapp.com/"},
        allowCredentials = "true"
)
public class LabelController {
    @Autowired
    LabelService service;

    @GetMapping("/api/labels")
    public List<Label> findAllLabels(){
        return service.findAllLabels();
    }

    @GetMapping("/api/labels/{lid}")
    public Label findLabelById(@PathVariable("lid") int labelId){
        return service.findLabelById(labelId);
    }

    @GetMapping("/api/labels/{lid}/notes")
    public List<Note> findNotesForLabel(@PathVariable("lid") int labelId){
        return service.findNotesByLabelId(labelId);
    }

    @GetMapping("/api/users/{uid}/labels")
    public List<Label> findLabelsByUser(@PathVariable("uid") int userId){
        return service.findLabelsByUser(userId);
    }

    @PostMapping("/api/users/{uid}/labels")
    public Label createLabelForUser(@PathVariable("uid") int userId, @RequestBody Label newLabel){
        return service.createLabelForUser(userId, newLabel);
    }

    @GetMapping("/api/folders/{fid}/labels")
    public List<Label> findLabelsByFolder(@PathVariable("fid") int folderId){
        return service.findLabelsByFolder(folderId);
    }

    @PostMapping("/api/folders/{fid}/labels")
    public Label createLabelForFolder(@PathVariable("fid") int folderId, @RequestBody Label newLabel){
        return service.createLabelForFolder(folderId, newLabel);
    }

    @PutMapping("/api/labels/{lid}")
    public int updateLabel(@PathVariable("lid") int labelId, @RequestBody Label updated){
        return service.updateLabel(labelId, updated);
    }

    @DeleteMapping("/api/labels/{lid}")
    public int deleteLabel(@PathVariable("lid") int labelId){
        return service.deleteLabel(labelId);
    }



}
