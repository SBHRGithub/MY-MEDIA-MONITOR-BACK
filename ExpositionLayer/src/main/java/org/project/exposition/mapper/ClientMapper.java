package org.project.exposition.mapper;

import org.project.domain.*;
import org.project.exposition.dto.*;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;


@Component
public class ClientMapper {


    public enum Score{


        NOTRATED(6),
        VERYGOOD(5),
        GOOD(4),
        AVERAGE(3),
        FAIR(2),
        BAD(1),
        NO(0);



        private final Integer number;

        Score(Integer number) {
            this.number = number;
        }
    }


    public ResultListMovieDto convertClientToResultListMovieDto(Client client){

        ResultListMovieDto resultListMovieDto = new ResultListMovieDto();

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

            resultListMovieDto.setResults(resultMovieDtoList);
        }

        return resultListMovieDto;
    }



    public ResultListTVShowDto convertClientToResultListTVShowDto(Client client){

        ResultListTVShowDto resultListTVShowDto= new ResultListTVShowDto();

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

            resultListTVShowDto.setResults(resultTVShowDtoList);
        }
        return resultListTVShowDto;
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

        if (dto.getViewingStatus()==""){
            followedMovie.setViewingStatus("Not seen");
        } else {
            followedMovie.setViewingStatus(dto.getViewingStatus());
        }

        if (dto.getMyScore().isEmpty()){
            followedMovie.setMyScore(Score.NOTRATED.number);
        } else {
            followedMovie.setMyScore(dto.getMyScore().get());
        }


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

        if (dto.getViewingStatus()==""){
            followedTVShow.setViewingStatus("Not seen");
        } else {
            followedTVShow.setViewingStatus(dto.getViewingStatus());
        }


        if (dto.getMyScore().isEmpty()){
            followedTVShow.setMyScore(Score.NOTRATED.number);
        } else {
            followedTVShow.setMyScore(dto.getMyScore().get());
        }

        if (dto.getOngoingSeason().isEmpty()){
            followedTVShow.setOngoingSeason(0);
        } else {
            followedTVShow.setMyScore(dto.getMyScore().get());
        };


        if (dto.getOngoingEpisode().isEmpty()){
            followedTVShow.setOngoingEpisode(0);
        } else {
            followedTVShow.setMyScore(dto.getMyScore().get());
        }




        followedTVShows.add(0,followedTVShow);

        client.setEmail(dto.getEmail());
        client.setFollowedTVShow(followedTVShows);


        return client;


    }

}
