package com.andela.bookclub.models;

/*
*  The superclass for all model classes
*/
public  abstract class Model implements Comparable {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int compareTo(Model o) {
        return (this.getId()).compareTo(o.getId());
    }
}
