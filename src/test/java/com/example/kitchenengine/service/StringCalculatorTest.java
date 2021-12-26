package com.example.kitchenengine.service;

import com.example.kitchenengine.utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {


    @Test
    public void emptyString_ReturnsZero() {
        assertEquals(1506, StringCalculator.add("1506"));
    }

    @Test
    public void whenMoreThan2NumbersAreUsed() {
        assertThrows(NumberFormatException.class, () -> {
            StringCalculator.add("1,2,3");
        });
    }

    @Test
    public void when2NumbersAreUsedthenNoException() {

        String numbers = "1,2,3";
        String[] args = numbers.split(",");
        List<String> number = Arrays.asList(args);

        List<String> integer = Arrays.asList(numbers);
        assertEquals(3, number.size());
        assertEquals("1", number.get(0));
        assertEquals("2", number.get(1));
        assertEquals("3", number.get(2));
    }

    @Test
    public void when_Counts() {
        List<Integer> countNumbers = Arrays.asList(1, 2, 3, 4);

        Integer i = countNumbers
                .stream()
                .mapToInt(Integer::valueOf).sum();

        assertEquals(10, i);
    }

    @Test
    public void whenCount() {
        List<Integer> numbers = Arrays.asList(1,2,3,4);
        Integer sum = numbers.stream().reduce(0,(a,b) -> a + b);
        assertEquals(10,sum);
    }

    @Test
    public void testUtils() {
        List<Integer>number = Arrays.asList(1,2,3,4);
        Integer answer = number.stream().reduce(0, Utils::add);
        assertEquals(10,answer);
    }
}

