package com.system.appointment2.model;

import javax.persistence.*;

@Entity
@Table(name = "lessPerformance")
public class LessPerformanceNote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String feedback;

    public LessPerformanceNote(String name, String feedback) {
        this.name = name;
        this.feedback = feedback;
    }

    public LessPerformanceNote() {
    }

    public LessPerformanceNote(String feedback) {
        this.feedback = feedback;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "LessPerformanceNote{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
