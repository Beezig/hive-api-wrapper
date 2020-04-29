package eu.beezig.hiveapi.wrapper.monthly;

import java.util.concurrent.CompletableFuture;

public interface MonthliesReady {

    CompletableFuture<? extends MonthlyProfile> getMonthlyProfile();
    CompletableFuture<? extends MonthlyProfile> getMonthlyProfile(String uuid);
    CompletableFuture<? extends MonthlyProfile> getMonthlyProfile(int humanPlace);

    CompletableFuture<? extends MonthlyLeaderboard> getMonthlyLeaderboard();
    CompletableFuture<? extends MonthlyLeaderboard> getMonthlyLeaderboard(int from, int to);

}
