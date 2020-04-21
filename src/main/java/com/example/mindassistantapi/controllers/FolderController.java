package com.example.mindassistantapi.controllers;

import com.example.mindassistantapi.models.Folder;
import com.example.mindassistantapi.services.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(
        origins = {"http://localhost:3000", "https://mind-assistant.herokuapp.com/"},
        allowCredentials = "true"
)
public class FolderController {
    @Autowired
    FolderService service;

    @GetMapping("/api/folders")
    public List<Folder> findAllFolders(){
        return service.findAllFolders();
    }

    @GetMapping("/api/folders/{uid}")
    public Folder findFolderById(@PathVariable("uid") int folderId){
        return service.findFolderById(folderId);
    }

    @GetMapping("/api/users/{uid}/folders")
    public List<Folder> findFoldersByUser(@PathVariable("uid") int userId){
        return service.findFoldersByUser(userId);
    }

    @PostMapping("/api/users/{uid}/folders")
    public Folder createFolder(@PathVariable("uid") int userId, @RequestBody Folder newFolder){
        return service.createFolder(userId, newFolder);
    }

    @PutMapping("/api/folders/{fid}")
    public int updateFolder(@PathVariable("fid") int folderId, @RequestBody Folder updated){
        return service.updateFolder(folderId, updated);
    }

    @DeleteMapping("/api/folders/{fid}")
    public int deleteFolder(@PathVariable("fid") int folderId){
        return service.deleteFolder(folderId);
    }
}
