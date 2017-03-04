package com.myAssortment.model;

public class Developer {
    private long id;
    private String name;
    private String slackName;

    public Developer(long id, String name, String slackName) {
        this.id = id;
        this.name = name;
        this.slackName = slackName;
    }

    public Developer(){ }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlackName() {
        return slackName;
    }

    public void setSlackName(String slackName) {
        this.slackName = slackName;
    }

}
