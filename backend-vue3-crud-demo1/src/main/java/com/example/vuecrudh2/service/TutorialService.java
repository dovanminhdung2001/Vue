package com.example.vuecrudh2.service;

import com.example.vuecrudh2.entity.Tutorial;
import com.example.vuecrudh2.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TutorialService {
    private final TutorialRepository tutorialRepository;

    public List<Tutorial> fillAll() {
        return tutorialRepository.findAll();
    }

    public Tutorial findById(String id) {
        return tutorialRepository.findById(id).get();
    }

    public Tutorial save(Tutorial tutorial) {
        return  tutorialRepository.save(tutorial);
    }

    public Tutorial update(Tutorial tutorial, String id) {
        tutorial.setId(id);
        return tutorialRepository.save(tutorial);
    }

    public boolean delete(String id) {
        Optional<Tutorial> tutorialOptional = tutorialRepository.findById(id);

        if(tutorialOptional.isEmpty())
            return false;

        tutorialRepository.delete(tutorialOptional.get());
        return true;
    }

    public void deleteAll() {
        tutorialRepository.deleteAll();
    }

    public List<Tutorial> findByTitle(String title) {
        List<Tutorial> tutorials = tutorialRepository.findAll();

        tutorials.forEach(x -> {
            if(!x.getTitle().contains(title))
                tutorials.remove(x);
        });
        return tutorials;
    }
}
