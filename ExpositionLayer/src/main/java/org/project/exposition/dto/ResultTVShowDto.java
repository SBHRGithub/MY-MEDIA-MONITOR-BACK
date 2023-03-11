package org.project.exposition.dto;

public class ResultTVShowDto {

    private Long externalId;

    private String name;

    private String mediaType;

    private String viewingStatus;

    private Integer myScore;

    private Integer ongoingSeason;

    private Integer ongoingEpisode;

    public ResultTVShowDto() {
    }

    public Long getExternalId() {
        return externalId;
    }

    public void setExternalId(Long externalId) {
        this.externalId = externalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
