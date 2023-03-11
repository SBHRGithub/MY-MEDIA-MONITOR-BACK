package org.project.configuration;


import org.project.domain.Client;


import org.project.dto.FollowedMovieDto;
import org.project.dto.FollowedTVShowDto;
import org.project.processor.ClientItemProcessor;
import org.project.reader.ClientItemReader;
import org.project.writer.ClientItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Autowired
    JobBuilderFactory jobBuilderFactory;



    @Bean
    public ItemReader<FollowedMovieDto> followedMovieDtoItemReader() throws IOException {


        return new ClientItemReader("followedmovie.csv");
    }



    @Bean
    public ItemProcessor<FollowedMovieDto, Client> convertFollowedMovieDtoToClient(){

        return new ClientItemProcessor();
    }


    @Bean
    public ItemWriter<Client> saveProductInDatabase(){

        return new ClientItemWriter();
    }
    @Bean
    public Step insertFollowedMovieToDatabase( ) throws IOException {
        return stepBuilderFactory.get("stepFollowedMovieToDatabase")
                .<FollowedMovieDto, Client>chunk(100)
                .reader(followedMovieDtoItemReader())
                .processor(convertFollowedMovieDtoToClient())
                .writer(saveProductInDatabase())
                .build();
    }

    @Bean
    public Job readCsvAndSaveInDatabase( ) throws IOException {
        return jobBuilderFactory.get("readFollowedMovieandSave")
                .start(insertFollowedMovieToDatabase())
                .build();
    }

}
