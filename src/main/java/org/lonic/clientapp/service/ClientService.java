package org.lonic.clientapp.service;

import org.lonic.clientapp.entity.Client;
import org.lonic.clientapp.model.response.client.ResponseClientCreate;
import org.lonic.clientapp.model.response.client.ResponseClientUpdate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    List<Client> findAll();

    ResponseClientCreate create(String name, String job);

    Client delete(Long id);

    ResponseClientUpdate update(Long id, String name, String job);
}
