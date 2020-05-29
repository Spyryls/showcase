package com.jasonvanblarcum.showcase.data;


import com.jasonvanblarcum.showcase.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;



@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername (String username);
}