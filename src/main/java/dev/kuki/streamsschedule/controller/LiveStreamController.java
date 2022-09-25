package dev.kuki.streamsschedule.controller;

import dev.kuki.streamsschedule.model.LiveStream;
import dev.kuki.streamsschedule.repository.LiveStreamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {

    private final LiveStreamRepository repository;

    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<LiveStream> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public LiveStream findById(@PathVariable String id) {
        return repository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LiveStream create(@RequestBody LiveStream stream) {
        return repository.create(stream);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody LiveStream stream, @PathVariable String id) {
        repository.update(stream, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }
}
