package org.project.service;

import org.project.domain.Client;


import java.util.Optional;

public interface IClientService {



    //VideoUser updateVideoUser(VideoUser videoUser);


    //Client findByEmail(String email);


    Client findClient(String email, Optional<String> title, Optional<String> mediaType, Optional<String> viewingStatus,  Optional<Integer> myScore);

    Client update(Client client);


}
