package com.enfocat.audiolibro.repositories;

import com.enfocat.audiolibro.models.Comments;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentsRepository extends CrudRepository<Comments, Long> {
    
    @Override
    List<Comments> findAll();

    public List<Comments> findByContentContaining(String content);

    public List<Comments> findByValoracionContaining(int valoracion);

    public List<Comments> findByChaptersid(long chaptersid);

}