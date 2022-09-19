package com.example.vuecrudh2.repository;

import com.example.vuecrudh2.entity.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TutorialRepository extends MongoRepository<Tutorial, String> {
}
