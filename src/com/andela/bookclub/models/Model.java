package com.andela.bookclub.models;


public  abstract class Model implements Comparable<Model> {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Comparable implementation

    public int compareTo(Model m1) {
        if (m1.getId() != null && this.getId() != null) {
            return this.getId().compareTo(m1.getId());
        }

        return 0;
    }
}
