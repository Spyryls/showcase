package com.jasonvanblarcum.showcase.data;

import com.jasonvanblarcum.showcase.models.Artwork;
import com.jasonvanblarcum.showcase.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtworkRepository extends CrudRepository<Artwork, Integer> {
}
