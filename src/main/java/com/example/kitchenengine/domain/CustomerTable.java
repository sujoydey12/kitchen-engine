package com.example.kitchenengine.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
@Builder
public class CustomerTable {

    private int id;
    private int tableNo;
    private Status status;
}
