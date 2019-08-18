package com.test.mvvmdemo.repository;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RawQuery;
import android.arch.persistence.room.Update;

import java.util.List;

/*
* Dao need to be either interface of abstract class, bcs we no need to provide the method body, we just create a method
* and annotate it, room will create corresponding code for us.
* */

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("delete from note_table")
    void deleteAll();

    @Query("select * from note_table order by priority desc")
    LiveData<List<Note>> getAllNotes();
}
