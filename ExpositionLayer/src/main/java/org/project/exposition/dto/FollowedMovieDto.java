package org.project.exposition.dto;

import java.util.Optional;

public class FollowedMovieDto {



    private String email;

    private String title;

    private Long externalId;

    private String mediaType;

    private String viewingStatus;

    private Optional<Integer> myScore;

    public FollowedMovieDto() {
    }

    public FollowedMovieDto(String email, String title, Long externalId, String mediaType, String viewingStatus, Optional<Integer> myScore) {
        this.email = email;
        this.title = title;
        this.externalId = externalId;
        this.mediaType = mediaType;
        this.viewingStatus = viewingStatus;
        this.myScore = myScore;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getExternalId() {
        return externalId;
    }

    public void setExternalId(Long externalId) {
        this.externalId = externalId;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getViewingStatus() {
        return viewingStatus;
    }

    public void setViewingStatus(String viewingStatus) {
        this.viewingStatus = viewingStatus;
    }

    public Optional<Integer> getMyScore() {
        return myScore;
    }

    public void setMyScore(Optional<Integer> myScore) {
        this.myScore = myScore;
    }
}
