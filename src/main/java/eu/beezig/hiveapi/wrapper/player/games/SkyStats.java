package eu.beezig.hiveapi.wrapper.player.games;

import eu.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import eu.beezig.hiveapi.wrapper.monthly.sky.SkyMonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.monthly.sky.SkyMonthlyProfile;
import eu.beezig.hiveapi.wrapper.player.PvPStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.concurrent.CompletableFuture;

public class SkyStats extends PvPStats implements Titleable, MonthliesReady {

    public SkyStats(JObject source) {
        super(source);
    }

    @Override
    public long getGamesPlayed() {
        return source.getLong("gamesplayed");
    }

    public long getMostPoints() {
        return source.getLong("most_points");
    }

    public long getTimeAlive() {
        return source.getLong("timealive");
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }

    @Override
    public CompletableFuture<SkyMonthlyProfile> getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public CompletableFuture<SkyMonthlyProfile> getMonthlyProfile(String uuid) {
        return JObject.get(new UrlBuilder().monthly().sky().profile(uuid).build()).thenApplyAsync(SkyMonthlyProfile::new);
    }

    @Override
    public CompletableFuture<SkyMonthlyProfile> getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).thenApplyAsync(lb -> lb.getProfiles().get(0));
    }

    @Override
    public CompletableFuture<SkyMonthlyLeaderboard> getMonthlyLeaderboard() {
        return JObject.get(new UrlBuilder().monthly().sky().leaderboard().build()).thenApplyAsync(SkyMonthlyLeaderboard::new);
    }

    @Override
    public CompletableFuture<SkyMonthlyLeaderboard> getMonthlyLeaderboard(int from, int to) {
        return JObject.get(new UrlBuilder().monthly().sky().leaderboard(from, to).build()).thenApplyAsync(SkyMonthlyLeaderboard::new);
    }

}
