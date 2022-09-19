package com.example.vuecrudh2.controller;

import com.example.vuecrudh2.entity.Tutorial;
import com.example.vuecrudh2.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TutorialController {
    @Autowired
    private TutorialService tutorialService;

    @GetMapping("/tutorials")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(tutorialService.fillAll());
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<?> get(@PathVariable("id") String id) {
        return tutorialService.findById(id) == null
                ? ResponseEntity.badRequest().body("k ton tai")
                : ResponseEntity.ok(tutorialService.findById(id));
    }

    @PostMapping("/tutorials")
    public ResponseEntity<?> create(@RequestBody Tutorial tutorial) {
        return ResponseEntity.ok(tutorialService.save(tutorial));
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<?> update(
            @PathVariable("id") String id,
            @RequestBody Tutorial tutorial
    ) {
        return ResponseEntity.ok(tutorialService.update(tutorial, id));
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        return tutorialService.delete(id)
                ? ResponseEntity.ok("ok")
                : ResponseEntity.badRequest().body("id sai");
    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<?> deleteAll() {
        tutorialService.deleteAll();
        return ResponseEntity.ok("deleteAll success");
    }

//    @GetMapping("/tutorials")
//    public ResponseEntity<?> findByTitle(@RequestParam("title") String title) {
//
//    }

//    @GetMapping("/tutorials")
//    public ResponseEntity<?> findByTitle(@RequestParam("title") String title) {
//        return ResponseEntity.ok(tutorialService.findByTitle(title));
//    }
}
