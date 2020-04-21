package com.example.mindassistantapi.services;

import com.example.mindassistantapi.models.Folder;
import com.example.mindassistantapi.models.Label;
import com.example.mindassistantapi.models.Note;
import com.example.mindassistantapi.models.User;
import com.example.mindassistantapi.repositories.FolderRepo;
import com.example.mindassistantapi.repositories.LabelRepo;
import com.example.mindassistantapi.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabelService {
    @Autowired
    LabelRepo labelRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    FolderRepo folderRepo;

    public List<Label> findAllLabels(){
        return labelRepo.findAllLabels();
    }

    public Label findLabelById(int labelId){
        return labelRepo.findLabelById(labelId);
    }

    // CrudRepo interface provides the findById method which returns an Optional<Label>
    // object that may or may not exist. Optional.get() returns the encapsulated object.
    public List<Note> findNotesByLabelId(int labelId) {
        Optional<Label> label = labelRepo.findById(labelId);
        return label.get().getNotes();
    }

    public List<Label> findLabelsByUser(int userId){
        return labelRepo.findLabelsByUser(userId);
    }

    public Label createLabelForUser(int userId, Label label){
        User user = userRepo.findUserById(userId);
        label.setUser(user);
        return labelRepo.save(label);
    }

    public List<Label> findLabelsByFolder(int folderId){
        return labelRepo.findLabelsByFolder(folderId);
    }

    public Label createLabelForFolder(int folderId, Label label){
        Folder folder = folderRepo.findFolderById(folderId);
        label.setFolder(folder);
        label.setUser(folder.getUser());
        return labelRepo.save(label);
    }

    public int updateLabel(int labelId, Label updatedLabel){
        Label label = labelRepo.findLabelById(labelId);
        updatedLabel.setUser(label.getUser());
        updatedLabel.setFolder(label.getFolder());
        labelRepo.save(updatedLabel);
        if(updatedLabel.equals(label)){
            return 1;
        } else {
            return 0;
        }
    }

    public int deleteLabel(int labelId){
        labelRepo.deleteById(labelId);
        if(labelRepo.findLabelById(labelId) == null) {
            return 1;
        } else {
            return 0;
        }
    }
}
