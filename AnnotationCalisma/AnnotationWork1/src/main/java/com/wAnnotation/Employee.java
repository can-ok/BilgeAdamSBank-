package com.wAnnotation;

import java.util.List;

@XmlObject
public class Employee {

    @XmlField(tag = "Name",tagAtt = "type")
    private String Name;

    @XmlField(tag = "Id",tagAtt = "type")
    private int Id;

    public Employee() {
    }

    public Employee(String name, int id) {
        Name = name;
        Id= id;
    }

    @XmlFieldReference(tag = "Jobs",type = "List")
    private List<Jobs> jobs = null;

    public List<Jobs> getJobs() {
        return jobs;
    }

    public void setJobs(List<Jobs> jobs) {
        this.jobs = jobs;
    }
}
