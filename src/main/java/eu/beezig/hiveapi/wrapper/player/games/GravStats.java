package eu.beezig.hiveapi.wrapper.player.games;

import eu.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import eu.beezig.hiveapi.wrapper.monthly.grav.GravMonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.monthly.grav.GravMonthlyProfile;
import eu.beezig.hiveapi.wrapper.player.GameStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class GravStats extends GameStats implements Titleable, MonthliesReady {

    public GravStats(JObject source) {
        super(source);
    }

    @Override
    public long getPoints() {
        return source.getLong("points");
    }

    public Map<String, Long> getMapRecords() {
        return source.getJSONObject("maprecords");
    }

    @Override
    public Date getFirstLogin() {
        return new Date(source.getLong("firstlogin") * 1000);
    }

    @Override
    public long getGamesPlayed() {
        return source.getLong("gamesplayed");
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }

    @Override
    public CompletableFuture<GravMonthlyProfile> getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public CompletableFuture<GravMonthlyProfile> getMonthlyProfile(String uuid) {
        return JObject.get(new UrlBuilder().monthly().grav().profile(uuid).build()).thenApplyAsync(GravMonthlyProfile::new);
    }

    @Override
    public CompletableFuture<GravMonthlyProfile> getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).thenApplyAsync(lb -> lb.getProfiles().get(0));
    }

    @Override
    public CompletableFuture<GravMonthlyLeaderboard> getMonthlyLeaderboard() {
        return JObject.get(new UrlBuilder().monthly().grav().leaderboard().build()).thenApplyAsync(GravMonthlyLeaderboard::new);
    }

    @Override
    public CompletableFuture<GravMonthlyLeaderboard> getMonthlyLeaderboard(int from, int to) {
        return JObject.get(new UrlBuilder().monthly().grav().leaderboard(from, to).build()).thenApplyAsync(GravMonthlyLeaderboard::new);
    }
}
