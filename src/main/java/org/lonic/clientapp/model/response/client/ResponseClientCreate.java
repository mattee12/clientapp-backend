package org.lonic.clientapp.model.response.client;

import lombok.Getter;
import org.lonic.clientapp.entity.Client;
import org.lonic.clientapp.enums.response.client.ResponseClientCreateType;

@Getter
public class ResponseClientCreate {
    private int httpStatus = 500;
    private String message;
    private Client result;

    private final ResponseClientCreateType status;

    public ResponseClientCreate(ResponseClientCreateType status, Client result){
        this(status);
        this.result = result;
    }

    public ResponseClientCreate(ResponseClientCreateType status){
        this.status = status;
        switch (status) {
            case SUCCESS -> {
                this.httpStatus = 200;
                this.message = "Client created successfully.";
            }
            case EMPTY_STRING -> {
                this.httpStatus = 400;
                this.message = "Please fill every field.";
            }
        }
    }
}
