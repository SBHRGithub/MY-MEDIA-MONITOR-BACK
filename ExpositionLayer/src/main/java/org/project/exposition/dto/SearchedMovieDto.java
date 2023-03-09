package org.project.exposition.dto;

import java.util.Optional;

public class SearchedMovieDto {


    private String email;

    private Optional<String> title;

    private Optional<String> mediaType;

    private Optional<String> viewingStatus;

    private Optional<Integer> myScore;

    public SearchedMovieDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Optional<String> getTitle() {
        return title;
    }

    public void setTitle(Optional<String> title) {
        this.title = title;
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
}

