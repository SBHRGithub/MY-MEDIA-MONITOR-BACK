package org.project.infrastructure;

import org.project.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IClientRepository extends JpaRepository<Client,String> {


    Optional<Client> findByEmail(String email);


}

