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
@EnableWebSecurity
public class ClientApi {

    @Autowired
    IClientService service;


    @Autowired
    ClientMapper mapper;

    Logger logger= LoggerFactory.getLogger(ClientApi.class);


    @CrossOrigin
    @GetMapping("/get/movie")
    public List<ResultMovieDto> findFollowedMovie(@RequestParam String email,
                                                    @RequestParam Optional<String> title,
                                                    @RequestParam Optional<String> mediaType,
                                                    @RequestParam Optional<String> viewingStatus,
                                                    @RequestParam Optional<Integer> myScore) {

        logger.debug("DEBUG---email = {}",email);
        logger.debug("DEBUG---title = {}",title.isPresent());
        logger.debug("DEBUG---mediaType = {}",mediaType.isPresent());
        logger.debug("DEBUG---viewingStatus = {}",viewingStatus.isPresent());
        logger.debug("DEBUG---myScore = {}",myScore.isPresent());


        logger.info("findFollowedMovie client : {}",email);

        Client client=service.findClient(email,title,mediaType,viewingStatus, myScore);

        List<ResultMovieDto> results=mapper.convertClientToResultMovieDto(client);

        return results;
    }



    @CrossOrigin
    @GetMapping("/get/tv")
    public List<ResultTVShowDto> findFollowedTVShow(@RequestParam String email,
                       @RequestParam Optional<String> name,
                       @RequestParam Optional<String> mediaType,
                       @RequestParam Optional<String> viewingStatus,
                       @RequestParam Optional<Integer> myScore) {

        logger.debug("DEBUG---email = {}",email);
        logger.debug("DEBUG---title = {}",name.isPresent());
        logger.debug("DEBUG---mediaType = {}",mediaType.isPresent());
        logger.debug("DEBUG---viewingStatus = {}",viewingStatus.isPresent());
        logger.debug("DEBUG---myScore = {}",myScore.isPresent());


        logger.info("findFollowedTVShow client : {}",email);

        Client client=service.findClient(email,name,mediaType,viewingStatus, myScore);

        List<ResultTVShowDto> results=mapper.convertClientToResultTVShowDto(client);

        return results;
    }



    @CrossOrigin
    @PostMapping("/post/movie")
    public ResponseEntity<Client> create(@RequestBody FollowedMovieDto followedMovieDto)
    {
        logger.info("save client : {}",followedMovieDto.getEmail());

        Client client=mapper.convertFollowedMovieDtoToClient(followedMovieDto);

        Client clientSaved = service.update(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientSaved);
    }



    @CrossOrigin
    @PostMapping("/post/tv")
    public ResponseEntity<Client> create(@RequestBody FollowedTVShowDto followedTVShowDto)
    {
        logger.info("save client : {}",followedTVShowDto.getEmail());

        Client client=mapper.convertFollowedTVShowDtoToClient(followedTVShowDto);

        Client clientSaved = service.update(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientSaved);
    }






}