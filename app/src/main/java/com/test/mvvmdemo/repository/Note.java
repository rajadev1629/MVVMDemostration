package com.test.mvvmdemo.repository;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

// By default table would be "Note", but for Sql naming convention rename this table with "note_table".

/*
* Column name by default the same as variable name, but we can change with the Annotation " @ColumnInfo(name = "prior")
* */

@Entity (tableName = "note_table")
public class Note {

    //Each sql table required a unique identity. so let android system generate primary key and handle it (autoGenerate = true).

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private int priority;

    public Note(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    /*
    * There is no need to create getter method, we can simply make all modifiers as public,
    * but for Encapsulation we generate getter method here.
    * */
}
