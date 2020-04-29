package eu.beezig.hiveapi.wrapper.test;

import eu.beezig.hiveapi.wrapper.HiveWrapper;
import eu.beezig.hiveapi.wrapper.exception.ProfileNotFoundException;
import eu.beezig.hiveapi.wrapper.player.Profiles;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletionException;
import java.util.concurrent.Executors;

public class ProfileDiscovery {
    @BeforeAll
    public static void setup() {
        HiveWrapper.setAsyncExecutor(Executors.newSingleThreadExecutor());
    }

    @Test
    public void correctProfile() {
        assert 1423599322L == Profiles.global("bba224a20bff4913b04227ca3b60973f").join().getFirstLogin().getTime() / 1000;
    }

    @Test
    public void shouldNotBeFound() {
        try {
            Profiles.global("a").join();
            org.junit.jupiter.api.Assertions.fail("Should be throwing an exception.");
        } catch(CompletionException ex) {
            assert ex.getCause() instanceof ProfileNotFoundException;
        }
    }
}
