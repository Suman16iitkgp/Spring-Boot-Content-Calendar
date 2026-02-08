package com.Suman16iitkgp.contentCalendar.controller;

import com.Suman16iitkgp.contentCalendar.model.Content;
import com.Suman16iitkgp.contentCalendar.model.Status;
import com.Suman16iitkgp.contentCalendar.model.Type;
import com.Suman16iitkgp.contentCalendar.repository.ContentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ContentControllerTest {

    @Mock
    ContentRepository contentRepository;

    ContentController contentController;

    @BeforeEach
    void setup(){
        contentController = new ContentController(contentRepository);
    }

    @Test
    void shouldReturnAllContents(){
        // Given
        List<Content> contentList = new ArrayList<>();
        Content content1 = new Content(1, "TestTitle", null, Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, null);
        contentList.add(content1);

        // When
        Mockito.when(contentRepository.findAll()).thenReturn(contentList);

        // Then
        List<Content> receivedOutput = contentController.findAll();
        assertNotNull(receivedOutput);
        assertEquals(1, receivedOutput.size());
        assertEquals(1, receivedOutput.get(0).id());
    }

    @Test
    void shouldTestGetContent(){
        // Given
        Content content1 = new Content(1, "TestTitle", null, Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, null);

        // When
        Mockito.when(contentRepository.findById(1)).thenReturn(Optional.of(content1));

        // Then
        Content content = contentController.getContent(1);
        assertNotNull(content);
        assertEquals(1, content.id());
    }

    @Test
    void shouldTestFindByTitle(){
        // Given
        List<Content> contentList = new ArrayList<>();
        Content content1 = new Content(1, "TestTitle", null, Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, null);
        contentList.add(content1);

        // When
        Mockito.when(contentRepository.findAllByTitleContains("Title")).thenReturn(contentList);

        // Then
        List<Content> receivedOutput = contentController.findByTitle("Title");
        assertNotNull(receivedOutput);
        assertEquals(1, receivedOutput.size());
    }

    @Test
    void shouldTestFindByStatus(){
        // Given
        List<Content> contentList = new ArrayList<>();
        Content content1 = new Content(1, "TestTitle", null, Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, null);
        contentList.add(content1);

        // When
        Mockito.when(contentRepository.listByStatus(Status.IDEA)).thenReturn(contentList);

        // Then
        List<Content> receivedOutput = contentController.findByStatus(Status.IDEA);
        assertNotNull(receivedOutput);
        assertEquals(1, receivedOutput.size());
    }

}
