package org.project.exposition.dto;

import java.util.List;

public class ResultListMovieDto {

    List<ResultMovieDto> results;

    public ResultListMovieDto() {
    }

    public ResultListMovieDto(List<ResultMovieDto> results) {
        this.results = results;
    }

    public List<ResultMovieDto> getResults() {
        return results;
    }

    public void setResults(List<ResultMovieDto> results) {
        this.results = results;
    }
}
