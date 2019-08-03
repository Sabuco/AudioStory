package com.enfocat.audiolibro.repositories;

import com.enfocat.audiolibro.models.Chapter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChapterRepository extends CrudRepository<Chapter, Long> {

   @Override
   List<Chapter> findAll();

   public List<Chapter> findByTitleContaining(String title);

   public List<Chapter> findByContentContaining(String content);
 
/*  Saber el numero de chapters que tenemos de una historia

select count(*) from chapters where storiesid=1;

select count(*) from chapters where storiesid=2;

---
   //@Query("Select s.title from stories s where s.title LIKE %?1%")
   public List<Story> findByTitleContaining(String title);
*/



}