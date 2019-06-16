package com.example.demo.repository;

import com.example.demo.models.Project;

import java.util.List;

public interface ProjectRepositoryCustom {

    List<Project> find(final String name);
}
