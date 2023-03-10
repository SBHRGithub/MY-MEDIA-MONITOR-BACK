package org.project.exposition.rest;



import org.project.domain.Client;
import org.project.exposition.dto.*;
import org.project.exposition.mapper.ClientMapper;
import org.project.service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientApi {

    @Autowired
    IClientService service;


    @Autowired
    ClientMapper mapper;

    Logger logger= LoggerFactory.getLogger(ClientApi.class);



    @GetMapping("/get/movie")

    public List<ResultMovieDto> findFollowedMovie(@RequestBody SearchedMovieDto SearchedMovieDto)
    {
        logger.info("findFollowedMovie client : {}",SearchedMovieDto.getEmail());

        Client client=service.findClient(SearchedMovieDto.getEmail(),SearchedMovieDto.getTitle(),SearchedMovieDto.getMediaType(),SearchedMovieDto.getViewingStatus(), SearchedMovieDto.getMyScore());

        List<ResultMovieDto> results=mapper.convertClientToResultMovieDto(client);

        return results;
    }


    @GetMapping("/get/tv")

    public List<ResultTVShowDto> findFollowedTVShow(@RequestBody SearchedTVShowDto SearchedTVShowDto)
    {
        logger.info("findFollowedTVShow client : {}",SearchedTVShowDto.getEmail());

        Client client=service.findClient(SearchedTVShowDto.getEmail(),SearchedTVShowDto.getName(),SearchedTVShowDto.getMediaType(),SearchedTVShowDto.getViewingStatus(), SearchedTVShowDto.getMyScore());

        List<ResultTVShowDto> results=mapper.convertClientToResultTVShowDto(client);

        return results;
    }





    @PostMapping("/post/movie")
    public ResponseEntity<Client> create(@RequestBody FollowedMovieDto followedMovieDto)
    {
        logger.info("save client : {}",followedMovieDto.getEmail());

        Client client=mapper.convertFollowedMovieDtoToClient(followedMovieDto);

        Client clientSaved = service.update(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientSaved);
    }




    @PostMapping("/post/tv")
    public ResponseEntity<Client> create(@RequestBody FollowedTVShowDto followedTVShowDto)
    {
        logger.info("save client : {}",followedTVShowDto.getEmail());

        Client client=mapper.convertFollowedTVShowDtoToClient(followedTVShowDto);

        Client clientSaved = service.update(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientSaved);
    }






}