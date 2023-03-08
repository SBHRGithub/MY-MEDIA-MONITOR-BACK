package org.project;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Si le package dans tous les modules n'ont pas la même racine (org.example, dans l'exemple), on doit ajoute la ligne suivante
//@SpringBootApplication(scanBasePackages = {"com.example","org.example"})

@SpringBootApplication(scanBasePackages = {"org.project","org.project.exposition"})
public class VideoExpositionStarter {

    public static void main(String[] args){
        SpringApplication.run(VideoExpositionStarter.class,args);
    }
}
