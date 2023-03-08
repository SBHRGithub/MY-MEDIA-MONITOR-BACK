package org.project.domain;

import javax.persistence.*;

@Entity
public class FollowedTVShow {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String viewingStatus;

    private Integer myScore;

    private Integer ongoingSeason;

    private Integer ongoingEpisode;

    @ManyToOne (cascade = {CascadeType.MERGE})
    private TVShow tvShow;

    public FollowedTVShow() {
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

    public void setMyScore(Integer myScore) {
        this.myScore = myScore;
    }

    public Integer getOngoingSeason() {
        return ongoingSeason;
    }

    public void setOngoingSeason(Integer ongoingSeason) {
        this.ongoingSeason = ongoingSeason;
    }

    public Integer getOngoingEpisode() {
        return ongoingEpisode;
    }

    public void setOngoingEpisode(Integer ongoingEpisode) {
        this.ongoingEpisode = ongoingEpisode;
    }

    public TVShow getTvShow() {
        return tvShow;
    }

    public void setTvShow(TVShow tvShow) {
        this.tvShow = tvShow;
    }

}
