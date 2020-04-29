package eu.beezig.hiveapi.wrapper.test;

import eu.beezig.hiveapi.wrapper.HiveWrapper;
import eu.beezig.hiveapi.wrapper.player.HivePlayer;
import eu.beezig.hiveapi.wrapper.player.Profiles;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ParallelJobs {
    @BeforeAll
    public static void setup() {
        HiveWrapper.setAsyncExecutor(Executors.newSingleThreadExecutor());
    }

    @Test
    public void runInParallel() throws InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture<Void> future = Profiles.global("bba224a20bff4913b04227ca3b60973f").thenAcceptAsync(_p -> {
            assert System.currentTimeMillis() - start < 3000L;
        });
        Thread.sleep(3000L);
        future.join();
    }

    @Test
    public void sumFirstLogins() throws ExecutionException, InterruptedException {
        CompletableFuture<HivePlayer> me = Profiles.global("bba224a20bff4913b04227ca3b60973f");
        CompletableFuture<HivePlayer> niklas = Profiles.global("8b687575275545069b37538b4865f92d");
        CompletableFuture.allOf(me, niklas).join();
        assert (1423599322L + 1361809633L) == (me.get().getFirstLogin().getTime() / 1000 + niklas.get().getFirstLogin().getTime() / 1000);
    }
}
