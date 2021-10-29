package com.example.kitchenengine.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
public class Table {

    private int id;
    private int tableNo;
    private Status status;
}
