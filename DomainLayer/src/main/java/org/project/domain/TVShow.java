package org.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TVShow {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long externalId;

    private String name;

    private String mediaType;


    public TVShow() {
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
}
