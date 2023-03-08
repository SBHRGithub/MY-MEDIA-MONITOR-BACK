package org.project.exposition;

import org.project.domain.Client;
import org.project.service.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/client")
public class ClientApi {

    @Autowired
    IClientService service;

    Logger logger= LoggerFactory.getLogger(ClientApi.class);


    @GetMapping
    @ResponseBody
    public Client find(@RequestParam String email,
                                             @RequestParam Optional<String> title,
                                             @RequestParam Optional<String> mediaType,
                                             @RequestParam Optional<String> viewingStatus,
                                             @RequestParam Optional<Integer> myScore

    )
    {

        logger.debug("DEBUG---email = {}",email);
        logger.debug("DEBUG---title = {}",title.isPresent());
        logger.debug("DEBUG---mediaType = {}",mediaType.isPresent());
        logger.debug("DEBUG---viewingStatus = {}",viewingStatus.isPresent());
        logger.debug("DEBUG---myScore = {}",myScore.isPresent());

        logger.info("find client : {}",email);

        Client client=service.findClient(email,title,mediaType,viewingStatus,myScore);

        return client;

    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client){

        logger.info("save client : {}",client.getEmail());

        Client clientSaved = service.update(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }







}
