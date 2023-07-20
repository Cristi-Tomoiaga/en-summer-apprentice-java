package com.endava.ticketsjavabackend.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "event_type")
public class EventType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_type_id")
    private Integer id;

    @Column(name = "event_type_name")
    private String name;

    public EventType() {
    }

    public EventType(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
