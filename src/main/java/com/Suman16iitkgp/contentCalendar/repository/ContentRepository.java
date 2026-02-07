package com.Suman16iitkgp.contentCalendar.repository;

import com.Suman16iitkgp.contentCalendar.model.Content;
import com.Suman16iitkgp.contentCalendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

    List<Content> findAllByTitleContains(String keyword);

    @Query("""
        SELECT * FROM Content 
        WHERE status=:status
    """)
    List<Content> listByStatus(@Param("status") Status status);
}
