package org.project.infrastructure;

import org.project.domain.Movie;
import org.project.domain.TVShow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITVShowRepository extends JpaRepository<TVShow,Long> {

    Optional<TVShow> findByExternalId(Long id);
}
