package com.test.mvvmdemo.repository;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;


/*
* Entity is required to which table need to contains for this database, we can add multiple table by using of
* "  {}  "
* */

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    public static NoteDatabase instance;

    public abstract NoteDao noteDao();

    public static synchronized NoteDatabase getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class,"note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        return instance;
    }

    /*
    * Here the list will open up with empty table so better to start with empty table we can start with some data.
    * */

    private static RoomDatabase.Callback roomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            new PopulateDbAsyncTask(instance).execute();
            super.onCreate(db);
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        NoteDao noteDao;
        PopulateDbAsyncTask(NoteDatabase noteDatabase) {
            this.noteDao = noteDatabase.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert(new Note("Title1", "Description1", 10));
            noteDao.insert(new Note("Title2", "Description2", 5));
            noteDao.insert(new Note("Title3", "Description3", 2 ));
            return null;
        }
    }
}
