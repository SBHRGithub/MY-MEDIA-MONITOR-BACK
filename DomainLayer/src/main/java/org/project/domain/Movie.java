package org.project.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long externalId;

    private String title;

    private String mediaType;


    public Movie() {
    }


    public Movie(Long externalId, String title, String mediaType) {
        this.externalId = externalId;
        this.title = title;
        this.mediaType = mediaType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExternalId() {
        return externalId;
    }

    public void setExternalId(Long externalId) {
        this.externalId = externalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
}
