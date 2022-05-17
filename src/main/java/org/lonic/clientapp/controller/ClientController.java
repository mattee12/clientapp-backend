package org.lonic.clientapp.controller;

import lombok.RequiredArgsConstructor;
import org.lonic.clientapp.entity.Client;
import org.lonic.clientapp.model.request.client.RequestClientCreate;
import org.lonic.clientapp.model.request.client.RequestClientUpdate;
import org.lonic.clientapp.model.response.client.ResponseClientCreate;
import org.lonic.clientapp.model.response.client.ResponseClientUpdate;
import org.lonic.clientapp.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public List<Client> findAll(){
        return clientService.findAll();
    }

    @PostMapping
    public ResponseEntity<ResponseClientCreate> create(@RequestBody RequestClientCreate requestClientCreate){
        final ResponseClientCreate result = clientService.create(requestClientCreate.getName(), requestClientCreate.getJob());
        return ResponseEntity.status(result.getHttpStatus()).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> delete(@PathVariable Long id){
        final Client result = clientService.delete(id);
        return result != null ?  ResponseEntity.ok(result): ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseClientUpdate> update(@PathVariable Long id, @RequestBody RequestClientUpdate requestClientUpdate){
        final ResponseClientUpdate result = clientService.update(id, requestClientUpdate.getName(), requestClientUpdate.getJob());
        return ResponseEntity.status(result.getHttpStatus()).body(result);
    }
}
