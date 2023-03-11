package org.project.exposition.dto;

import java.util.List;

public class ResultListTVShowDto {


    List<ResultTVShowDto> results;


    public ResultListTVShowDto() {
    }

    public ResultListTVShowDto(List<ResultTVShowDto> results) {
        this.results = results;
    }


    public List<ResultTVShowDto> getResults() {
        return results;
    }

    public void setResults(List<ResultTVShowDto> results) {
        this.results = results;
    }
}
