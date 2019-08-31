package com.rathoreapps.team.retrofitpractice;

public class modelClass {
    String id;
    String title;

    public modelClass(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String setId(String id) {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
