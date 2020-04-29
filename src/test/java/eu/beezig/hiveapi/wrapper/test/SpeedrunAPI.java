package eu.beezig.hiveapi.wrapper.test;

import eu.beezig.hiveapi.wrapper.HiveWrapper;
import eu.beezig.hiveapi.wrapper.player.Profiles;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;

public class SpeedrunAPI {
    @BeforeAll
    public static void setup() {
        HiveWrapper.setAsyncExecutor(Executors.newSingleThreadExecutor());
    }

    @Test
    public void correctResult() {
        Profiles.speedrun("5wkk0xvw").join();
    }
}
