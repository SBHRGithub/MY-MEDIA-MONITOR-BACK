package org.project.service;

import org.project.domain.Client;
import org.project.domain.FollowedMovie;
import org.project.domain.FollowedTVShow;


import java.util.List;
import java.util.Optional;

public interface IClientService {



    //VideoUser updateVideoUser(VideoUser videoUser);


    //Client findByEmail(String email);


    Client findClient(String email, Optional<String> title, Optional<String> mediaType, Optional<String> viewingStatus,  Optional<Integer> myScore);

    Client update(Client client);


    List<FollowedTVShow> findFollowedTVShow(String email, Optional<String> name, Optional<String> mediaType, Optional<String> viewingStatus, Optional<Integer> myScore);

    List<FollowedMovie> findFollowedMovie(String email, Optional<String> title, Optional<String> mediaType, Optional<String> viewingStatus, Optional<Integer> myScore);
}
