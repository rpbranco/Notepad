package pt.ulisboa.tecnico.cmov.notepad;

import android.app.Application;

import java.util.ArrayList;

public class GlobalClass extends Application {
    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<String> contents = new ArrayList<>();
    private int open = 0;

    public void addNote(String title, String content) {
        this.titles.add(title);
        this.contents.add(content);
    }

    public Note getNote(int position) {
        return new Note(this.titles.get(position), this.contents.get(position));
    }

    public ArrayList<String> getTitles() {
        return this.titles;
    }

    public void setOpen(int position) {
        this.open = position;
    }

    public int getOpen() {
        return this.open;
    }

}
