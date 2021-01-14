package com.wAnnotation;

@XmlObject
public class Jobs {

    @XmlField(tag = "Name",tagAtt = "type")
    private String name;

    @XmlField(tag = "Id",tagAtt = "type")
    private int id;

    public Jobs(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Jobs() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
