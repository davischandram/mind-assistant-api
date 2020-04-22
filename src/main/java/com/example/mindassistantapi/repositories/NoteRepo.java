package com.example.mindassistantapi.repositories;

import com.example.mindassistantapi.models.Note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteRepo extends JpaRepository<Note, Integer> {
    @Query("select note from Note note")
    public List<Note> findAllNotes();

    @Query("select note from Note note where note.id=:nid")
    public Note findNoteById(@Param("nid") int noteId);

    @Query("select note from Note note where note.user.id=:uid")
    public List<Note> findNotesByUser(@Param("uid") int userId);

    @Query("select note from Note note where note.folder.id=:fid")
    public List<Note> findNotesByFolder(@Param("fid") int folderId);

    @Query("select n from Note n where note like %?1%")
    public List<Note> searchForNote(String note);
}
