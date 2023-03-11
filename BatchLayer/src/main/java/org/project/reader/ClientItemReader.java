package org.project.reader;


import com.opencsv.CSVReader;


import org.project.dto.FollowedMovieDto;
import org.project.dto.FollowedTVShowDto;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.io.FileReader;
import java.io.IOException;

public class ClientItemReader implements ItemReader<FollowedMovieDto> {
    private String filePath;
    CSVReader csvReader;

    String[] nextLines;


    public ClientItemReader(String filePath) throws IOException {


        this.filePath=filePath;
        csvReader=new CSVReader(new FileReader(filePath));
        csvReader
                .skip(1);//Permet de ne pas prendre en compte le Header du fichier CSV


    }


    public FollowedMovieDto read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        nextLines=csvReader
                .readNext();
        if(nextLines==null){
            return null;
        }

        String email=nextLines[0];
        String title=nextLines[1];
        Long externalId=Long.parseLong(nextLines[2]);
        String mediaType=nextLines[3];
        String viewingStatus=nextLines[4];
        Integer myScore=Integer.parseInt(nextLines[5]);


        return new FollowedMovieDto(email,title,externalId,mediaType,viewingStatus,myScore);
    }



}
