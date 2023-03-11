package org.project.exposition.dto;

import java.util.Optional;

public class FollowedTVShowDto {



    private String email;

    private String name;

    private Long externalId;

    private String mediaType;

    private String viewingStatus;

    private Optional<Integer> myScore;

    private Optional<Integer> ongoingSeason;

    private Optional<Integer> ongoingEpisode;


    public FollowedTVShowDto() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
