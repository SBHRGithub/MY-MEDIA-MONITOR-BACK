package org.project.infrastructure;

import org.project.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IMovieRepository extends JpaRepository<Movie,Long> {
    Optional<Movie> findByExternalId(Long id);
}
