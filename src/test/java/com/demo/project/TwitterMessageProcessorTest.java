package com.demo.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TwitterMessageProcessorTest {

    private TwitterMessageProcessor twitterMessageProcessor;

    @BeforeEach
    void setUp() {
        twitterMessageProcessor = new TwitterMessageProcessor();
    }

    @Test
    void testProcessor(){
        List<String> twits = new ArrayList<>();
        twits.add("#Java and #Scala are the languages of cognitive and AI development. IBM sees cognitive development is the future.");
        twits.add("Some more info on the IBM investment in #Scala and Lightbendhttp8/ibm-lightbend-join-forces-enterpri");
        twits.add("IBM and @lightbend are building an integrated platform for #Java and #Scala #cognitive app development");

        List<String> expected = List.of("Scala", "Java", "cognitive");

        assertEquals(expected, twitterMessageProcessor.proccess(twits));
    }
}