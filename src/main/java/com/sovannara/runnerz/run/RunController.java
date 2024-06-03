package com.sovannara.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {
//    // private instance variable
//    private final InMemoryRunRepository runRepository;
//    // constructor
//    public RunControllerWithInMemory(InMemoryRunRepository inMemoryRunRepository) {
//        this.inMemoryRunRepository = inMemoryRunRepository;
//    }

    // private instance variable
    private final JdbcRunRepository runRepository;
    // constructor
    RunController(JdbcRunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping
    List<Run> findAll() {
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> runOptional = runRepository.findById(id);

        if (runOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run not found");
        }

        return runOptional.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    void create(@RequestBody Run runDto) {
        runRepository.create(runDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@PathVariable Integer id, @RequestBody Run runDto) {
        runRepository.update(runDto, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        runRepository.delete(id);
    }
}
