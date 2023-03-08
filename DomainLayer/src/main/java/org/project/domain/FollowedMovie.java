package org.project.domain;

import javax.persistence.*;

@Entity
public class FollowedMovie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String viewingStatus;

    private Integer myScore;


    @ManyToOne (cascade = {CascadeType.MERGE})
    private Movie movie;



    public FollowedMovie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getViewingStatus() {
        return viewingStatus;
    }

    public void setViewingStatus(String viewingStatus) {
        this.viewingStatus = viewingStatus;
    }

    public Integer getMyScore() {
        return myScore;
    }

    public void setMyScore(int myScore) {
        this.myScore = myScore;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
