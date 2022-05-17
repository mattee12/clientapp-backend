package org.lonic.clientapp.model.request.client;

import lombok.Data;

@Data
public class RequestClientUpdate {
    private Long Id;
    private String name;
    private String job;
}
