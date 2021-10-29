package com.example.kitchenengine;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountersTest {


    @Test
    public void givenGlobalRegistry_whenIncrementAnywhere_thenCount() {
        class CountedObject {
            private CountedObject(){
                Metrics.counter("object.instance").increment(1.0);
            }
        }
        Metrics.addRegistry(new SimpleMeterRegistry());
        Metrics.counter("object.instance").increment();
        Optional<Counter> optionalCounter =
                Optional.ofNullable(Metrics.globalRegistry.find("object.instance")
                .counter());
        assertTrue(optionalCounter.isPresent());
        assertTrue(optionalCounter.get().count() ==2.0);
    }

    @Test
    public void testCounter() {
        Counter counter = Counter
                .builder("instance")
                .description("indicates instance count of the object")
                .tags("dev","performance")
                .register(new SimpleMeterRegistry());

        counter.increment(2.0);
        assertTrue(counter.count()==2);
        counter.increment(-1);
        assertTrue(counter.count()==1);
    }

    @Test
    public void testTimer() {
        SimpleMeterRegistry simpleMeterRegistry = new SimpleMeterRegistry();
        Timer timer = simpleMeterRegistry.timer("app.event");
        timer.record(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(15);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        timer.record(30,TimeUnit.MILLISECONDS);
        assertTrue(2 ==timer.count());
        assertThat(timer.totalTime(TimeUnit.SECONDS)).isBetween(40.0,55.0);

    }
}
