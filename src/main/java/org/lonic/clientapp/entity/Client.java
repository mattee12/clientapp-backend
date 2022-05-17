package org.lonic.clientapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private Long Id;

    private String name;
    private String job;
}
