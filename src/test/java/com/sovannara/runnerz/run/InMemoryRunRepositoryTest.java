package com.sovannara.runnerz.run;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryRunRepositoryTest {
    InMemoryRunRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryRunRepository();
        repository.create(
                new Run(
                        1,
                        "Monday Morning Run",
                        LocalDateTime.now(),
                        LocalDateTime.now().plusMinutes(30),
                        3,
                        Location.INDOOR
                )
        );
        repository.create(
                new Run(
                        2,
                        "Tuesday Afternoon Run",
                        LocalDateTime.now(),
                        LocalDateTime.now().plusMinutes(60),
                        6,
                        Location.OUTDOOR
                )
        );
    }

    @Test
    void shouldFindAllRuns() {
        List<Run> runs = repository.findAll();
        // message param display only when the test failed
        assertEquals(2, runs.size(), "Should have returned 2 runs");
    }

    @Test
    void shouldFindRunWithValidId() {
        var run = repository.findById(1).get();
        assertEquals("Monday Morning Run", run.title());
        assertEquals(3, run.miles());
        assertEquals(Location.INDOOR, run.location());
    }

    @Test
    void shouldNotFindRunWithInvalidId() {
        RunNotFoundException notFoundException = assertThrows(RunNotFoundException.class, () -> repository.findById(-1).get());
        assertEquals("Run not found", notFoundException.getMessage());
    }

    @Test
    void shouldCreateNewRun() {
        repository.create(
                new Run(
                        3,
                        "Wednesday Evening Run",
                        LocalDateTime.now(),
                        LocalDateTime.now().plusMinutes(20),
                        9,
                        Location.INDOOR
                )
        );
        List<Run> runs = repository.findAll();
        assertEquals(3, runs.size(), "Should have returned 3 runs");
    }

    @Test
    void shouldUpdateRun() {
        repository.update(
                new Run(
                        1,
                        "Monday Evening Run",
                        LocalDateTime.now(),
                        LocalDateTime.now().plusMinutes(90),
                        15,
                        Location.OUTDOOR
                ), 1
        );
        var run = repository.findById(1).get();
        assertEquals("Monday Evening Run", run.title());
        assertEquals(15, run.miles());
        assertEquals(Location.OUTDOOR, run.location());
    }

    @Test
    void shouldDeleteRun() {
        repository.delete(2);
        List<Run> runs = repository.findAll();
        assertEquals(1, runs.size(), "Should have returned 1 run");
    }
}