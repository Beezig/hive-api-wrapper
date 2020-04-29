package eu.beezig.hiveapi.wrapper.player.games;

import eu.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import eu.beezig.hiveapi.wrapper.monthly.timv.TimvMonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.monthly.timv.TimvMonthlyProfile;
import eu.beezig.hiveapi.wrapper.player.GameStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

public class TimvStats extends GameStats implements MonthliesReady, Titleable {

    public TimvStats(JObject source) {
        super(source);
    }

    public long getRolePoints() {
        return source.getLong("role_points");
    }

    public long getInnocentPoints() {
        return source.getLong("i_points");
    }

    public long getDetectivePoints() {
        return source.getLong("d_points");
    }

    public long getTraitorPoints() {
        return source.getLong("t_points");
    }

    public long getMostPoints() {
        return source.getLong("most_points");
    }

    @Override
    public Date getFirstLogin() {
        return null;
    }

    @Override
    public Date getCachedAt() {
        return null;
    }

    @Override
    public long getVictories() {
        return -1;
    }

    @Override
    public long getGamesPlayed() {
        return -1;
    }

    public boolean hasDetectiveStick() {
        return source.getBoolean("detectivebook");
    }

    @Override
    public CompletableFuture<TimvMonthlyProfile> getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public CompletableFuture<TimvMonthlyProfile> getMonthlyProfile(String uuid) {
        return JObject.get(new UrlBuilder().monthly().timv().profile(uuid).build()).thenApplyAsync(TimvMonthlyProfile::new);
    }

    @Override
    public CompletableFuture<TimvMonthlyProfile> getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).thenApplyAsync(lb -> lb.getProfiles().get(0));
    }

    @Override
    public CompletableFuture<TimvMonthlyLeaderboard> getMonthlyLeaderboard() {
        return JObject.get(new UrlBuilder().monthly().timv().leaderboard().build()).thenApplyAsync(TimvMonthlyLeaderboard::new);
    }

    @Override
    public CompletableFuture<TimvMonthlyLeaderboard> getMonthlyLeaderboard(int from, int to) {
        return JObject.get(new UrlBuilder().monthly().timv().leaderboard(from, to).build()).thenApplyAsync(TimvMonthlyLeaderboard::new);
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }
}
