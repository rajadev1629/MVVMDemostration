package com.test.mvvmdemo.repository;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public abstract class NoteDaoCopy {

    /*
    * In this class we all have only abstract method, so for this kind of situation always choose Interface, because
    * Interface all method by default " PUBLIC & ABSTRACT " by default.
    * */

    @Insert
    public abstract void insert(Note note);

    @Update
    public abstract void update(Note note);

    @Delete
    public abstract void delete(Note note);

    @Query("delete from note_table")
    public abstract void deleteAll();

    @Query("select * from note_table order by priority desc")
    public abstract LiveData<List<Note>> getAllNotes();
}
