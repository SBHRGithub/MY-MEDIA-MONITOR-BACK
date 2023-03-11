package org.project.exposition.mapper;

import org.project.domain.*;
import org.project.exposition.dto.FollowedMovieDto;
import org.project.exposition.dto.FollowedTVShowDto;
import org.project.exposition.dto.ResultMovieDto;
import org.project.exposition.dto.ResultTVShowDto;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;


@Component
public class ClientMapper {


    public List<ResultMovieDto> convertClientToResultMovieDto(Client client){

        List<ResultMovieDto> resultMovieDtoList = new ArrayList<>();


        if (!(client.getFollowedMovie()==null)) {

            for (int i=0;i<client.getFollowedMovie().size();i++){

                ResultMovieDto resultMovieDto = new ResultMovieDto();

                resultMovieDto.setExternalId(client.getFollowedMovie().get(i).getMovie().getExternalId());
                resultMovieDto.setTitle(client.getFollowedMovie().get(i).getMovie().getTitle());
                resultMovieDto.setMediaType(client.getFollowedMovie().get(i).getMovie().getMediaType());
                resultMovieDto.setViewingStatus(client.getFollowedMovie().get(i).getViewingStatus());
                resultMovieDto.setMyScore((client.getFollowedMovie().get(i).getMyScore()));

                resultMovieDtoList.add(resultMovieDto);

            }
        }

        return resultMovieDtoList;
    }



    public List<ResultTVShowDto> convertClientToResultTVShowDto(Client client){

        List<ResultTVShowDto> resultTVShowDtoList = new ArrayList<>();


        if (!(client.getFollowedTVShow()==null)) {
            for (int i=0;i<client.getFollowedTVShow().size();i++){

                ResultTVShowDto resultTVShowDto = new ResultTVShowDto();

                resultTVShowDto.setExternalId(client.getFollowedTVShow().get(i).getTvShow().getExternalId());
                resultTVShowDto.setTitle(client.getFollowedTVShow().get(i).getTvShow().getName());
                resultTVShowDto.setMediaType(client.getFollowedTVShow().get(i).getTvShow().getMediaType());
                resultTVShowDto.setViewingStatus(client.getFollowedTVShow().get(i).getViewingStatus());
                resultTVShowDto.setMyScore((client.getFollowedTVShow().get(i).getMyScore()));
                resultTVShowDto.setOngoingSeason(client.getFollowedTVShow().get(i).getOngoingSeason());
                resultTVShowDto.setOngoingEpisode(client.getFollowedTVShow().get(i).getOngoingEpisode());

                resultTVShowDtoList.add(resultTVShowDto);


            }
        }
        return resultTVShowDtoList;
    }


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
