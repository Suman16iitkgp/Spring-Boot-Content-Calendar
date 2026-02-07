package com.Suman16iitkgp.contentCalendar.controller;

import com.Suman16iitkgp.contentCalendar.model.Content;
import com.Suman16iitkgp.contentCalendar.model.Status;
import com.Suman16iitkgp.contentCalendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/contents")
public class ContentController {

    private final ContentRepository contentRepository;

    public ContentController(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    // request to find all pieces of content

    @GetMapping(value = "")
    public List<Content> findAll() {
        return contentRepository.findAll();
    }


    // Create, Update, Delete

    @GetMapping("/{id}")
    public Content getContent(@PathVariable Integer id) {
        return contentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not able to find content"));
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody Content content){
        contentRepository.save(content);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Content content, @PathVariable Integer id){
        if(!contentRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }

        contentRepository.save(content);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable  Integer id){
        if(!contentRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid");
        }

        contentRepository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword) {
        return contentRepository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status){
        return contentRepository.listByStatus(status);
    }


}
