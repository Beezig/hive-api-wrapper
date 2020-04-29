package eu.beezig.hiveapi.wrapper.test;

import eu.beezig.hiveapi.wrapper.HiveWrapper;
import eu.beezig.hiveapi.wrapper.player.games.CaiStats;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;

public class Monthlies {
    @BeforeAll
    public static void setup() {
        HiveWrapper.setAsyncExecutor(Executors.newSingleThreadExecutor());
    }

    @Test
    public void correctProfile() {
        assert "7e23916cac7e45a29f610252791fed96"
                .equals(new CaiStats(null).getMonthlyProfile("7e23916cac7e45a29f610252791fed96").join().getUUID());
    }
}
