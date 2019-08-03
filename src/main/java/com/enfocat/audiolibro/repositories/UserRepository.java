package com.enfocat.audiolibro.repositories;

import com.enfocat.audiolibro.models.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
  //  User findById(long id);
 //public List<User> findById(long id);
}
