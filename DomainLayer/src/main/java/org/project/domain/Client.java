package org.project.domain;

import javax.persistence.*;
import java.util.List;


@Entity
public class Client {


    @Id
    @Column(unique = true)
    private String email;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE })
    private List<FollowedMovie> followedMovies;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE })
    private List<FollowedTVShow> followedTVShows;


    public Client() {
    }


    public Client(String email, List<FollowedMovie> followedMovies, List<FollowedTVShow> followedTVShows) {
        this.email = email;
        this.followedMovies = followedMovies;
        this.followedTVShows = followedTVShows;
    }



    public List<FollowedTVShow> getFollowedTVShow() {
        return followedTVShows;
    }

    public void setFollowedTVShow(List<FollowedTVShow> followedTVShows) {
        this.followedTVShows = followedTVShows;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<FollowedMovie> getFollowedMovie() {
        return followedMovies;
    }

    public void setFollowedMovie(List<FollowedMovie> followedMovies) {
        this.followedMovies = followedMovies;
    }





}
