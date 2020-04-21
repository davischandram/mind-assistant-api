package com.example.mindassistantapi.services;

import com.example.mindassistantapi.models.Folder;
import com.example.mindassistantapi.models.User;
import com.example.mindassistantapi.repositories.FolderRepo;
import com.example.mindassistantapi.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderService {
    @Autowired
    FolderRepo folderRepo;
    @Autowired
    UserRepo userRepo;

    public List<Folder> findAllFolders(){
        return folderRepo.findAllFolders();
    }

    public Folder findFolderById(int folderId){
        return folderRepo.findFolderById(folderId);
    }

    public List<Folder> findFoldersByUser(int userId){
        return folderRepo.findFoldersByUser(userId);
    }

    public Folder createFolder(int userId, Folder folder){
        User user = userRepo.findUserById(userId);
        folder.setUser(user);
        return folderRepo.save(folder);
    }

    public int updateFolder(int folderId, Folder updatedfolder){
        Folder folder = folderRepo.findFolderById(folderId);
        updatedfolder.setUser(folder.getUser());
        folderRepo.save(updatedfolder);
        if(updatedfolder.equals(folder)){
            return 1;
        } else {
            return 0;
        }
    }

    public int deleteFolder(int folderId){
        folderRepo.deleteById(folderId);
        if(folderRepo.findFolderById(folderId) == null) {
            return 1;
        } else {
            return 0;
        }
    }
}
