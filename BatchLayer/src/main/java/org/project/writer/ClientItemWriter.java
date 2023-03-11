package org.project.writer;



import org.project.domain.Client;
import org.project.service.IClientService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientItemWriter implements ItemWriter<Client> {

    @Autowired
    IClientService service;
    @Override
    public void write(List<? extends Client> list) throws Exception {
        for (Client client : list) {
            service.update(client) ;
        }
        //OU
        //list.forEach((produit) -> service.create(produit));
    }
}
