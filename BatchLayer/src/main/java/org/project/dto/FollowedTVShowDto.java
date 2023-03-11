package org.project.dto;

public class FollowedTVShowDto {



    private String email;

    private String name;

    private Long externalId;

    private String mediaType;

    private String viewingStatus;

    private Integer myScore;

    private Integer ongoingSeason;

    private Integer ongoingEpisode;


    public FollowedTVShowDto() {
    }

    public FollowedTVShowDto(String email, String name, Long externalId, String mediaType, String viewingStatus, Integer myScore, Integer ongoingSeason, Integer ongoingEpisode) {
        this.email = email;
        this.name = name;
        this.externalId = externalId;
        this.mediaType = mediaType;
        this.viewingStatus = viewingStatus;
        this.myScore = myScore;
        this.ongoingSeason = ongoingSeason;
        this.ongoingEpisode = ongoingEpisode;
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
}
