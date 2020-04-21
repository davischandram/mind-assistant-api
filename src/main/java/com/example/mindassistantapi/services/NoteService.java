package com.example.mindassistantapi.services;

import com.example.mindassistantapi.models.Folder;
import com.example.mindassistantapi.models.Label;
import com.example.mindassistantapi.models.Note;
import com.example.mindassistantapi.models.User;
import com.example.mindassistantapi.repositories.FolderRepo;
import com.example.mindassistantapi.repositories.NoteRepo;
import com.example.mindassistantapi.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    NoteRepo noteRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    FolderRepo folderRepo;

    public List<Note> findAllNotes(){
        return noteRepo.findAllNotes();
    }

    public Note findNoteById(int noteId){
        return noteRepo.findNoteById(noteId);
    }

    public List<Note> findNotesByUser(int userId){
        return noteRepo.findNotesByUser(userId);
    }

    public Note createNoteForUser(int userId, Note note){
        User user = userRepo.findUserById(userId);
        note.setUser(user);
        return noteRepo.save(note);
    }

    public List<Note> findNotesByFolder(int folderId){
        return noteRepo.findNotesByFolder(folderId);
    }

    public Note createNoteForFolder(int folderId, Note note){
        Folder folder = folderRepo.findFolderById(folderId);
        note.setFolder(folder);
        note.setUser(folder.getUser());
        return noteRepo.save(note);
    }

    public int updateNote(int noteId, Note updatedNote){
        Note note = noteRepo.findNoteById(noteId);
        updatedNote.setUser(note.getUser());
        updatedNote.setFolder(note.getFolder());
        noteRepo.save(updatedNote);
        if(updatedNote.equals(note)){
            return 1;
        } else {
            return 0;
        }
    }

    public int deleteNote(int noteId){
        noteRepo.deleteById(noteId);
        if(noteRepo.findNoteById(noteId) == null) {
            return 1;
        } else {
            return 0;
        }
    }

    // SEARCH IMPLEMENTATION

    public List<Note> searchForNote(String note){
        return noteRepo.searchForNote(note);
    }

    public List<Label> findLabelsByNoteId(int noteId) {
        Note note = noteRepo.findById(noteId).get();
        return note.getLabels();
    }

}
