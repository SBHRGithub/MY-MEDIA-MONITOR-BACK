package org.project.exposition.dto;

import java.util.Optional;

public class SearchedTVShowDto {


    private String email;


    private Optional<String> name;

    private Optional<String> mediaType;

    private Optional<String> viewingStatus;

    private Optional<Integer> myScore;

    private Optional<Integer> ongoingSeason;

    private Optional<Integer> ongoingEpisode;

    public SearchedTVShowDto() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Optional<String> getName() {
        return name;
    }

    public void setName(Optional<String> name) {
        this.name = name;
    }

    public Optional<String> getMediaType() {
        return mediaType;
    }

    public void setMediaType(Optional<String> mediaType) {
        this.mediaType = mediaType;
    }

    public Optional<String> getViewingStatus() {
        return viewingStatus;
    }

    public void setViewingStatus(Optional<String> viewingStatus) {
        this.viewingStatus = viewingStatus;
    }

    public Optional<Integer> getMyScore() {
        return myScore;
    }

    public void setMyScore(Optional<Integer> myScore) {
        this.myScore = myScore;
    }

    public Optional<Integer> getOngoingSeason() {
        return ongoingSeason;
    }

    public void setOngoingSeason(Optional<Integer> ongoingSeason) {
        this.ongoingSeason = ongoingSeason;
    }

    public Optional<Integer> getOngoingEpisode() {
        return ongoingEpisode;
    }

    public void setOngoingEpisode(Optional<Integer> ongoingEpisode) {
        this.ongoingEpisode = ongoingEpisode;
    }
}
