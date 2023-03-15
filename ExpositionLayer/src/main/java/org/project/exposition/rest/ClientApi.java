package org.project.exposition.rest;



import org.project.domain.Client;
import org.project.domain.FollowedMovie;
import org.project.domain.FollowedTVShow;
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
@RequestMapping
@EnableWebSecurity
public class ClientApi {

    @Autowired
    IClientService service;


    @Autowired
    ClientMapper mapper;

    Logger logger= LoggerFactory.getLogger(ClientApi.class);


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get/movie")
    public ResultListMovieDto findFollowedMovie(@RequestParam String email,
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

        List<FollowedMovie> followedMovies;


        followedMovies =service.findFollowedMovie(email,title,mediaType,viewingStatus, myScore);


        ResultListMovieDto results=mapper.convertClientToResultListMovieDto(followedMovies);

        return results;
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get/tv")
    public ResultListTVShowDto findFollowedTVShow(@RequestParam String email,
                                                  @RequestParam Optional<String> name,
                                                  @RequestParam Optional<String> mediaType,
                                                  @RequestParam Optional<String> viewingStatus,
                                                  @RequestParam Optional<Integer> myScore) {

        logger.debug("DEBUG---email = {}",email);
        logger.debug("DEBUG---name = {}",name.isPresent());
        logger.debug("DEBUG---mediaType = {}",mediaType.isPresent());
        logger.debug("DEBUG---viewingStatus = {}",viewingStatus.isPresent());
        logger.debug("DEBUG---myScore = {}",myScore.isPresent());


        logger.info("findFollowedTVShow client : {}",email);

        List<FollowedTVShow> followedTVShows;


        followedTVShows =service.findFollowedTVShow(email,name,mediaType,viewingStatus, myScore);


        ResultListTVShowDto results=mapper.convertClientToResultListTVShowDto(followedTVShows);

        return results;
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/post/movie")
    public ResponseEntity<Client> create(@RequestBody FollowedMovieDto followedMovieDto)
    {
        logger.info("save client : {}",followedMovieDto.getEmail());

        Client client=mapper.convertFollowedMovieDtoToClient(followedMovieDto);

        Client clientSaved = service.update(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientSaved);
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/post/tv")
    public ResponseEntity<Client> create(@RequestBody FollowedTVShowDto followedTVShowDto)
    {
        logger.info("save client : {}",followedTVShowDto.getEmail());

        Client client=mapper.convertFollowedTVShowDtoToClient(followedTVShowDto);

        Client clientSaved = service.update(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientSaved);
    }






}