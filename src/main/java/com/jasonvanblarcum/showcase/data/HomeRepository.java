package com.jasonvanblarcum.showcase.data;

import com.jasonvanblarcum.showcase.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface HomeRepository extends JpaRepository<User, Long> {
}