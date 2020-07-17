package com.mechanitis.demo.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Lehre {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
   // private Integer age;


    public Lehre(String firstName, String lastName, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }


}
