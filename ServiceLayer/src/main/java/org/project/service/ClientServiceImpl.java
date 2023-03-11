package org.project.service;

import org.project.domain.*;
import org.project.infrastructure.IClientRepository;

import org.project.infrastructure.IMovieRepository;
import org.project.infrastructure.ITVShowRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class ClientServiceImpl implements IClientService {



    public enum TypeOfMedia{
        MOVIE ("movie"),
        TV("tv");

        private final String type;

        TypeOfMedia(String type) {
            this.type = type;
        }
    }

    // enum for viewingStatus
    public enum StatusOfViewing {


        ONGOING("Ongoing"),
        VIEWED("Viewed"),
        TOSEE("To see"),
        NOTSEEN("Not seen"),
        UNFOLLOW("Unfollow");


        private final String text;

        StatusOfViewing(String text) {
            this.text=text;
        }

    }


    Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);
    @Autowired
    IClientRepository repoClient;

    @Autowired
    IMovieRepository repoMovie;

    @Autowired
    ITVShowRepository repoTVShow;

    Optional<Client> optionalClientDatabase;

    FollowedMovie followedMovie;

    FollowedTVShow followedTVShow;

    List<FollowedMovie> followedMovies;

    List<FollowedTVShow> followedTVShows;






    public Client findClient(String email, Optional<String> title, Optional<String> mediaType, Optional<String> viewingStatus, Optional<Integer> myScore)
    {


        // Get all the data about the client
        optionalClientDatabase = repoClient.findByEmail(email);
        logger.debug("service findClient {}", email);

        Client client=new Client();

        if (optionalClientDatabase.isPresent()) {

            logger.info("client found in database : {}",email);

            client = optionalClientDatabase.get();

            followedMovies = optionalClientDatabase.get().getFollowedMovie();
            followedTVShows = optionalClientDatabase.get().getFollowedTVShow();

            // filter followedMovies and followedTVShows by title
            if (title.isPresent()) {

                logger.info("followedMovies filter by title : {}",title.get());

                followedMovies = followedMovies.stream()
                        .filter(f -> f.getMovie().getTitle().toLowerCase().equals(title.get().toLowerCase()))
                        .collect(Collectors.toList());

                followedTVShows = followedTVShows.stream()
                        .filter(f -> f.getTvShow().getName().toLowerCase().equals(title.get().toLowerCase()))
                        .collect(Collectors.toList());

                client = new Client(email, followedMovies, followedTVShows);

            }

            // filter followedMovies and followedTVShows by viewingStatus
            if (viewingStatus.isPresent()) {

                logger.info("followedMovies filter by viewingStatus : {}",viewingStatus.get());

                followedMovies = followedMovies.stream()
                        .filter(f -> f.getViewingStatus().equals(viewingStatus.get()))
                        .collect(Collectors.toList());

                followedTVShows = followedTVShows.stream()
                        .filter(f -> f.getViewingStatus().equals(viewingStatus.get()))
                        .collect(Collectors.toList());

                client = new Client(email, followedMovies, followedTVShows);

            }

            // filter followedMovies and followedTVShows by myScore
            if (myScore.isPresent()) {

                logger.info("followedMovies filter by myScore : {}",myScore.get());

                followedMovies = followedMovies.stream()
                        .filter(f-> f.getMyScore().equals(myScore.get()))
                        .collect(Collectors.toList());

                followedTVShows = followedTVShows.stream()
                        .filter(f -> f.getMyScore().equals(myScore.get()))
                        .collect(Collectors.toList());

                client = new Client(email, followedMovies, followedTVShows);

            }

            // filter followedMovies and followedTVShows by mediaType

            if (mediaType.isPresent()) {

                logger.info("followedMovies filter by mediaType : {}",mediaType.get());

                if (mediaType.get().equals(TypeOfMedia.MOVIE.type)) {

                    client = new Client(email, followedMovies, null);

                } else if (mediaType.get().equals(TypeOfMedia.TV.type)) {

                    client = new Client(email, null, followedTVShows);

                }

            }



        }


        return client;
    }




    public Client createClientNotInDatabase(Client client){


        if (client.getFollowedMovie() != null) {

            // Get id of the movie
            Optional<Movie> optionalMovie = repoMovie.findByExternalId(client.getFollowedMovie().get(0).getMovie().getExternalId());


            // Set id of the optionalMovie with the id found in the database, in order not to create the movie again in the database
            if (optionalMovie.isPresent()){

                client.getFollowedMovie().get(0).getMovie().setId(optionalMovie.get().getId());

            }

            if (client.getFollowedMovie().get(0).getViewingStatus().equals(StatusOfViewing.TOSEE.text)){

                client.getFollowedMovie().get(0).setViewingStatus(StatusOfViewing.NOTSEEN.text);

            }

        } else if (client.getFollowedTVShow() != null) {

            Optional<TVShow> optionalTVShow = repoTVShow.findByExternalId(client.getFollowedTVShow().get(0).getTvShow().getExternalId());

            // Set id of the followedTVShow with the id found in the database, in order not to create the TVShow again in the database

            if (optionalTVShow.isPresent()){

                client.getFollowedTVShow().get(0).getTvShow().setId(optionalTVShow.get().getId());

            }


            if (client.getFollowedTVShow().get(0).getViewingStatus().equals(StatusOfViewing.TOSEE.text)){

                client.getFollowedTVShow().get(0).setViewingStatus(StatusOfViewing.NOTSEEN.text);

            }

        }

        repoClient.save(client);
        return client;

    }

    @Override
    public Client update(Client client) {

        // Get all data in the database about Client
        optionalClientDatabase = repoClient.findByEmail(client.getEmail());



        // No data in database about Client so we create the client in database
        if (optionalClientDatabase.isEmpty()){

            client = createClientNotInDatabase(client);

        }
        // Client already in database so we update the client in database with the followedMovie
        else if (optionalClientDatabase.isPresent() & client.getFollowedMovie() != null ){

            client = updateClientFollowedMovie(client);
        // Client already in database so we update the client in database with the followedTVShow
        } else if (client.getFollowedTVShow() != null) {

            client = updateClientFollowedTVShow(client);

        }

        return client;
    }

    public Client updateClientFollowedTVShow(Client client) {


        int indexFollowedTVShow;


        followedTVShow=client.getFollowedTVShow().get(0);

        if (followedTVShow.getViewingStatus().equals(StatusOfViewing.TOSEE.text)){

            followedTVShow.setViewingStatus(StatusOfViewing.NOTSEEN.text);

        }

        // Get id of the TV show
        Optional<TVShow> optionalTVShow = repoTVShow.findByExternalId(followedTVShow.getTvShow().getExternalId());


        // Set id of the followedTVShow with the id found in the database, in order not to create the TVShow in the database

        if (optionalTVShow.isPresent()){

            logger.info("tv show found in the database");
            followedTVShow.getTvShow().setId(optionalTVShow.get().getId());

        }

        followedTVShows = optionalClientDatabase.get().getFollowedTVShow();


        // search for the id of the followedTV with the external id of the TVShow
        indexFollowedTVShow = IntStream.range(0, followedTVShows.size())
                .filter(i -> Objects.equals(followedTVShows.get(i).getTvShow().getExternalId(), followedTVShow.getTvShow().getExternalId()))
                .findFirst()
                .orElse(-1);


        // followedTVShow found in the database
        if (indexFollowedTVShow != -1) {

            logger.info("followedTVShow found in database");

            if (followedTVShow.getViewingStatus().equals(StatusOfViewing.UNFOLLOW.text)){

                    // remove the followedTV from the list
                    followedTVShows.remove(indexFollowedTVShow);

                    logger.info("followedTVShow removed from the list");

                }

                else {

                    // update the followedTVShow with the new data
                    followedTVShows.get(indexFollowedTVShow).setMyScore(followedTVShow.getMyScore());
                    followedTVShows.get(indexFollowedTVShow).setViewingStatus(followedTVShow.getViewingStatus());
                    followedTVShows.get(indexFollowedTVShow).setOngoingSeason(followedTVShow.getOngoingSeason());
                    followedTVShows.get(indexFollowedTVShow).setOngoingEpisode(followedTVShow.getOngoingEpisode());

                    logger.info("followedTVShow updated with the new data");

                }

        } else {

            // add the followedTVShow to the list of followedTVShow
            optionalClientDatabase.get().getFollowedTVShow().add(optionalClientDatabase.get().getFollowedTVShow().size(), followedTVShow);
            logger.info("followedTVShow added to the list");
        }




        repoClient.save(optionalClientDatabase.get());

        logger.info("client saved");

        return client;

    }

    public Client updateClientFollowedMovie(Client client) {


        int indexFollowedMovie;


        followedMovie=client.getFollowedMovie().get(0);

        if (followedMovie.getViewingStatus().equals(StatusOfViewing.TOSEE.text)){

            followedMovie.setViewingStatus("Not seen");

        }

        followedMovies= optionalClientDatabase.get().getFollowedMovie();


        // Get id of the movie
        Optional<Movie> optionalMovie = repoMovie.findByExternalId(followedMovie.getMovie().getExternalId());


        // Set id of the optionalMovie with the id found in the database, in order not to create the movie again in the database
        if (optionalMovie.isPresent()){

            logger.info("movie found in the database");
            followedMovie.getMovie().setId(optionalMovie.get().getId());

        }


        // search for the index of the followedMovie with the external id of the movie
        indexFollowedMovie = IntStream.range(0, followedMovies.size())
                .filter(i -> Objects.equals(followedMovies.get(i).getMovie().getExternalId(), followedMovie.getMovie().getExternalId()))
                .findFirst()
                .orElse(-1);

        // followedMovie found in the database
        if (indexFollowedMovie != -1) {

            if (followedMovie.getViewingStatus().equals(StatusOfViewing.UNFOLLOW.text)){

                // remove the followedMovie from the database
                followedMovies.remove(indexFollowedMovie);

                logger.info("followedMovie removed from the list");

            }

            else {

                // update the followedMovie with the new data
                followedMovies.get(indexFollowedMovie).setMyScore(followedMovie.getMyScore());
                followedMovies.get(indexFollowedMovie).setViewingStatus(followedMovie.getViewingStatus());

                logger.info("followedMovie updated with the new data");

            }
        } else {

            // add the followedMovie to the list of followedTVShow
            optionalClientDatabase.get().getFollowedMovie().add(optionalClientDatabase.get().getFollowedMovie().size(), followedMovie);
            logger.info("followedMovie added to the list");
        }





        repoClient.save(optionalClientDatabase.get());
        logger.info("client saved");


        return client;
    }


}