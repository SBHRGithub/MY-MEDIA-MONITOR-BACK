package org.project.processor;


import org.project.domain.Client;

import org.project.dto.FollowedMovieDto;
import org.project.mapper.ClientMapper;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientItemProcessor implements ItemProcessor<FollowedMovieDto, Client> {

    @Autowired
    ClientMapper mapper;
    @Override
    public Client process(FollowedMovieDto followedMovieDto) throws Exception {
        return mapper.convertFollowedMovieDtoToClient(followedMovieDto);
    }
}
