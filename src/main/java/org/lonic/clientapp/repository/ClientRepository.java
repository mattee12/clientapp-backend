package org.lonic.clientapp.repository;

import org.lonic.clientapp.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    @Override
    List<Client> findAll();
}
