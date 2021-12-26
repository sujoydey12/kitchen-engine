package com.example.kitchenengine.service;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class MoodAnalyserTest {

    @Test
    void testMoodAnalysis() throws Exception {
         MoodAnalyser moodAnalyser = new MoodAnalyser();
         String message = moodAnalyser.analyseMood("This is a sad message");

         assertThat(message, CoreMatchers.is("SAD"));
    }
}
