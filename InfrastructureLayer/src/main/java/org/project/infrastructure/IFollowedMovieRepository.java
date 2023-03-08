package org.project.infrastructure;

import org.project.domain.FollowedMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IFollowedMovieRepository extends JpaRepository<FollowedMovie,Long> {
}
