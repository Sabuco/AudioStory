package com.enfocat.audiolibro.repositories;

import com.enfocat.audiolibro.models.Story;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StoryRepository extends CrudRepository<Story, Long> {
  
    //@Query("Select s.title from stories s where s.title LIKE %?1%")
   
  
    
    public List<Story> findByTitleContaining(String title);
   
   @Override
    List<Story> findAll();


}
