package com.tanko.app.entry;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter


public class Cat {

    private String name;
    private int age;
    private int weight;

    public Cat(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Cat() {
    }


}
