package org.lonic.clientapp.model.response.client;

import lombok.Getter;
import org.lonic.clientapp.entity.Client;
import org.lonic.clientapp.enums.response.client.ResponseClientUpdateType;

@Getter
public class ResponseClientUpdate {
    private int httpStatus = 500;
    private String message;
    private Client result;

    private final ResponseClientUpdateType status;

    public ResponseClientUpdate(ResponseClientUpdateType status, Client result){
        this(status);
        this.result = result;
    }

    public ResponseClientUpdate(ResponseClientUpdateType status){
        this.status = status;
        switch (status) {
            case SUCCESS -> {
                this.httpStatus = 200;
                this.message = "Client updated successfully.";
            }
            case EMPTY_STRING -> {
                this.httpStatus = 400;
                this.message = "Please fill every field.";
            }
            case NOT_FOUND -> {
                this.httpStatus = 404;
                this.message = "Requested client not found.";
            }
        }
    }
}
