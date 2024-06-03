package com.sovannara.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class InMemoryRunRepository {
    // private instance variable
    private static final Logger log = LoggerFactory.getLogger(InMemoryRunRepository.class);

    private final List<Run> runs = new ArrayList<>();

    public List<Run> findAll() {
        return runs;
    }

    public Optional<Run> findById(Integer id) {
        return runs.stream().filter((runDto) -> Objects.equals(runDto.id(), id)).findFirst();
    }

    public void create(Run runDto) {
        Run newRun = new Run(
                runDto.id(),
                runDto.title(),
                runDto.startedOn(),
                runDto.completedOn(),
                runDto.miles(),
                runDto.location()
        );

        runs.add(newRun);
    }

    public void update(Integer id, Run newRun) {
        Optional<Run> runExist = findById(id);

        if (runExist.isPresent()) {
            var r = runExist.get();
            log.info("Updating Existing Run >>>>> " + runExist.get());
            runs.set(runs.indexOf(r), newRun);
        }
    }

    public void delete(Integer id) {
        log.info("Deleting Existing Run >>>>> " + id);
        runs.removeIf(runDto -> runDto.id().equals(id));
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(1,
                "Monday Morning Run",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                3,
                Location.INDOOR));

        runs.add(new Run(2,
                "Wednesday Evening Run",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(60),
                6,
                Location.INDOOR));
    }
}
