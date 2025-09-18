package com.tanko.app.repository;

import com.tanko.app.entry.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepo extends JpaRepository<People, Integer> {
}


