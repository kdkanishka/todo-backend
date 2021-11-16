package com.kani.dto;

import javax.persistence.*;

@Entity
@Table(name = "todoentry")
public class ToDoEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "done")
    private Boolean done;

    public ToDoEntry() {
    }

    public ToDoEntry(Long id, String text, Boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }

    public ToDoEntry(String text, Boolean done) {
        this.text = text;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
