package dev.kuki.streamsschedule.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class LiveStreamTest {

    @Test
    public void create_new_mutable_live_stream() {
        MutableLiveStream stream = new MutableLiveStream();
        stream.setId(UUID.randomUUID().toString());
        stream.setDescription("""
                Hello! my name is Kunal Saini. Some more about me. This and that. Bla bla bla
                some more text. text and text i do this and that. i study at this college and that's it.
                """);
        stream.setUrl("www.google.com");
        stream.setTitle("Learning Rest API");
        stream.setStartDate(LocalDateTime.of(2001, 12, 31, 0, 0));
        stream.setStartDate(LocalDateTime.of(2001, 12, 31, 23, 59));

        assertNotNull(stream);
        assertEquals("Learning Rest API", stream.getTitle(), "true");
    }

    @Test
    public void create_new_immutable_live_stream() {
        ImmutableLiveStream stream = new ImmutableLiveStream(
                UUID.randomUUID().toString(),
                "Learning Rest API",
                """
                    Hello! my name is Kunal Saini. Some more about me. This and that. Bla bla bla
                    some more text. text and text i do this and that. i study at this college and that's it.
                    """,
                "www.google.com",
                LocalDateTime.of(2001, 12, 31, 0, 0),
                LocalDateTime.of(2001, 12, 31, 23, 59));

        assertNotNull(stream);
        assertEquals("Learning Rest API", stream.getTitle(), "true");
    }

    @Test
    public void create_new_record_live_stream() {
        LiveStream stream = new LiveStream(
                UUID.randomUUID().toString(),
                "Learning Rest API",
                """
                    Hello! my name is Kunal Saini. Some more about me. This and that. Bla bla bla
                    some more text. text and text i do this and that. i study at this college and that's it.
                    """,
                "www.google.com",
                LocalDateTime.of(2001, 12, 31, 0, 0),
                LocalDateTime.of(2001, 12, 31, 23, 59));

        assertNotNull(stream);
        assertEquals("Learning Rest API", stream.title(), "true");
        assertTrue(stream.getClass().isRecord());
        assertEquals(6,stream.getClass().getRecordComponents().length);
    }

}