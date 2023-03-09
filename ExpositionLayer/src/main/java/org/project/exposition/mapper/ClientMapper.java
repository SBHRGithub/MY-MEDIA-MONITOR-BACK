package org.project.exposition.mapper;

import org.project.domain.*;
import org.project.exposition.dto.FollowedMovieDto;
import org.project.exposition.dto.FollowedTVShowDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ClientMapper {



    public Client convertFollowedMovieDtoToClient(FollowedMovieDto dto){
        Client client=new Client();
        FollowedMovie followedMovie= new FollowedMovie();
        List<FollowedMovie> followedMovies= new ArrayList<>();
        Movie movie=new Movie();


        movie.setTitle(dto.getTitle());
        movie.setExternalId(dto.getExternalId());
        movie.setMediaType(dto.getMediaType());

        followedMovie.setMovie(movie);
        followedMovie.setViewingStatus(dto.getViewingStatus());
        followedMovie.setMyScore(dto.getMyScore());

        followedMovies.add(0,followedMovie);

        client.setEmail(dto.getEmail());
        client.setFollowedMovie(followedMovies);


        return client;
    }


    public Client convertFollowedTVShowDtoToClient(FollowedTVShowDto dto){
        Client client=new Client();
        FollowedTVShow followedTVShow=new FollowedTVShow();
        TVShow tvShow=new TVShow();
        List<FollowedTVShow> followedTVShows=new ArrayList<>();



        tvShow.setName(dto.getName());
        tvShow.setExternalId(dto.getExternalId());
        tvShow.setMediaType(dto.getMediaType());

        followedTVShow.setTvShow(tvShow);
        followedTVShow.setViewingStatus(dto.getViewingStatus());
        followedTVShow.setMyScore(dto.getMyScore());
        followedTVShow.setOngoingSeason((dto.getOngoingSeason()));
        followedTVShow.setOngoingEpisode(dto.getOngoingEpisode());

        followedTVShows.add(0,followedTVShow);

        client.setEmail(dto.getEmail());
        client.setFollowedTVShow(followedTVShows);


        return client;


    }

}
