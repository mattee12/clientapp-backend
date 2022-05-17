package org.lonic.clientapp.service;

import lombok.RequiredArgsConstructor;
import org.lonic.clientapp.entity.Client;
import org.lonic.clientapp.enums.response.client.ResponseClientCreateType;
import org.lonic.clientapp.enums.response.client.ResponseClientUpdateType;
import org.lonic.clientapp.model.response.client.ResponseClientCreate;
import org.lonic.clientapp.model.response.client.ResponseClientUpdate;
import org.lonic.clientapp.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    @Override
    public ResponseClientCreate create(String name, String job){
        for(String val : new String[]{name, job}){
            if(!validateString(val)){return new ResponseClientCreate(ResponseClientCreateType.EMPTY_STRING);}
        }
        Client newClient = new Client();

        newClient.setName(name);
        newClient.setJob(job);

        return new ResponseClientCreate(ResponseClientCreateType.SUCCESS, clientRepository.save(newClient));
    }

    @Override
    public Client delete(Long id){
        Optional<Client> query = clientRepository.findById(id);
        if(query.isEmpty()) { return null; }

        Client toDelete = query.get();
        clientRepository.delete(toDelete);
        return toDelete;
    }

    @Override
    public ResponseClientUpdate update(Long id, String name, String job){
        for(String val : new String[]{name, job}){
            if(!validateString(val)){return new ResponseClientUpdate(ResponseClientUpdateType.EMPTY_STRING);}
        }
        Optional<Client> query = clientRepository.findById(id);
        if(query.isEmpty()){return new ResponseClientUpdate(ResponseClientUpdateType.NOT_FOUND);}

        Client original = query.get();
        original.setName(name);
        original.setJob(job);

        return new ResponseClientUpdate(ResponseClientUpdateType.SUCCESS, clientRepository.save(original));
    }

    //Returns false if the given text is empty, true otherwise.
    Boolean validateString(String val){
        return val != null && !val.trim().equals("");
    }
}
