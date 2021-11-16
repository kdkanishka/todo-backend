package com.kani.service;

import com.kani.dto.ToDoEntry;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ToDoService implements PanacheRepository<ToDoEntry> {
}
