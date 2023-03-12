package org.project.infrastructure;

import org.project.domain.FollowedTVShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFollowedTVShowRepository extends JpaRepository<FollowedTVShow,Long> {
}
