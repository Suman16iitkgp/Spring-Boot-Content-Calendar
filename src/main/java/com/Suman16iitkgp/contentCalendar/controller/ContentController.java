package com.Suman16iitkgp.contentCalendar.controller;

import com.Suman16iitkgp.contentCalendar.model.Content;
import com.Suman16iitkgp.contentCalendar.repository.ContentCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/contents")
public class ContentController {

    private final ContentCollectionRepository contentCollectionRepository;

    public ContentController(ContentCollectionRepository contentCollectionRepository1) {
        this.contentCollectionRepository = contentCollectionRepository1;
    }

    // request to find all pieces of content

    @GetMapping(value = "")
    public List<Content> findAll() {
        return contentCollectionRepository.findAll();
    }


    // Create, Update, Delete

    @GetMapping("/{id}")
    public Content getContent(@PathVariable Integer id) {
        return contentCollectionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not able to find content"));
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody Content content){
        contentCollectionRepository.save(content);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Content content, @PathVariable Integer id){
        if(!contentCollectionRepository.existById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }

        contentCollectionRepository.save(content);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable  Integer id){
        if(!contentCollectionRepository.existById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid");
        }

        contentCollectionRepository.deleteById(id);
    }


}
