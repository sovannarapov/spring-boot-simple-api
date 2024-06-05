package com.sovannara.runnerz.run;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@Import(JdbcRunRepository.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JdbcRunRepositoryTest {
    @Autowired
    JdbcRunRepository repository;

    @BeforeEach
    void setUp() {
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
                        "Wednesday Evening Run",
                        LocalDateTime.now(),
                        LocalDateTime.now().plusMinutes(30),
                        6,
                        Location.INDOOR
                )
        );
    }

    @Test
    void shouldFindAllRuns() {
        List<Run> runs = repository.findAll();
        assertEquals(2, runs.size());
        assertNotNull(runs);
    }

    @Test
    void shouldFindRunById() {
        var run = repository.findById(1).get();
        assertEquals("Monday Morning Run", run.title());
        assertEquals(3, run.miles());
        assertEquals(Location.INDOOR, run.location());
    }

    @Test
    void shouldNotFindRunByInvalidId() {
        var run = repository.findById(-1);
        assertTrue(run.isEmpty());
    }

    @Test
    void shouldCreateNewRun() {
        repository.create(
                new Run(
                        3,
                        "Friday Afternoon Run",
                        LocalDateTime.now(),
                        LocalDateTime.now().plusMinutes(50),
                        5,
                        Location.OUTDOOR
                )
        );
        List<Run> runs = repository.findAll();
        assertEquals(3, runs.size());
    }

    @Test
    void shouldUpdateRun() {
        repository.update(
                new Run(
                        1,
                        "Monday Afternoon Run",
                        LocalDateTime.now(),
                        LocalDateTime.now().plusMinutes(50),
                        10,
                        Location.OUTDOOR
                ), 1
        );
        var run = repository.findById(1).get();
        assertEquals("Monday Afternoon Run", run.title());
        assertEquals(10, run.miles());
        assertEquals(Location.OUTDOOR, run.location());
    }

    @Test
    void shouldDeleteRun() {
        repository.delete(2);
        List<Run> runs = repository.findAll();
        assertEquals(1, runs.size());
    }
}
