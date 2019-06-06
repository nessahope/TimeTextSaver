package com.hope.nessa.texttimesaver.model;

import java.lang.annotation.Target;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Contact {

    private String firstName;
    private String lastName;
    private String phoneNumber;


    @Override
    public String toString() {
        return firstName + " " + lastName + "\n" + phoneNumber;
    }
}
