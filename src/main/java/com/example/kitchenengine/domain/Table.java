package com.example.kitchenengine.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Table {

    private int id;
    private int tableNo;
    private Status status;
}
