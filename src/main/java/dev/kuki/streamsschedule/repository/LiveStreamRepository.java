package dev.kuki.streamsschedule.repository;

import dev.kuki.streamsschedule.model.LiveStream;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class LiveStreamRepository {
    List<LiveStream> streams = new ArrayList<>();

    public LiveStreamRepository() {
        streams.add(new LiveStream(
                UUID.randomUUID().toString(),
                "Learning Rest API",
                """
                        Hello! my name is Kunal Saini. Some more about me. This and that. Bla bla bla
                        some more text. text and text i do this and that. i study at this college and that's it.
                        """,
                "www.google.com",
                LocalDateTime.of(2001, 12, 31, 0, 0),
                LocalDateTime.of(2001, 12, 31, 23, 59)
        ));
    }

    public List<LiveStream> findAll() {
        return streams;
    }

    public LiveStream findById(String id) {
        return streams.stream().filter(streams -> streams.id().equals(id)).findFirst().orElse(null);
    }

    public LiveStream create(LiveStream stream) {
        streams.add(stream);
        return stream;
    }

    public void update(LiveStream stream, String id) {
        LiveStream existing = streams.stream().filter(s -> s.id().equals(id)).findFirst().orElseThrow(() -> new IllegalArgumentException("String Not Found"));
        int i = streams.indexOf(existing);
        streams.set(i, stream);
    }

    public void delete(String id) {
        streams.removeIf(stream -> stream.id().equals(id));
    }
}
