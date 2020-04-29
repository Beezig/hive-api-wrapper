package eu.beezig.hiveapi.wrapper.player.games;

import eu.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import eu.beezig.hiveapi.wrapper.monthly.cai.CaiMonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.monthly.cai.CaiMonthlyProfile;
import eu.beezig.hiveapi.wrapper.player.GameStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

public class CaiStats extends GameStats implements Titleable, MonthliesReady {

    public CaiStats(JObject source) {
        super(source);
    }

    @Override
    public long getGamesPlayed() {
        return source.getLong("gamesplayed");
    }

    public long getCaptures() {
        return source.getLong("captures");
    }

    public long getCaptured() {
        return source.getLong("captured");
    }

    public long getCatches() {
        return source.getLong("catches");
    }

    public long getCaught() {
        return source.getLong("caught");
    }

    public boolean hasTeamSelector() {
        return source.getBoolean("teamselector");
    }

    public boolean hasCreeperFirework() {
        return source.getBoolean("creeperfirework");
    }

    @Override
    public Date getFirstLogin() {
        return new Date(source.getLong("firstlogin") * 1000);
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }

    @Override
    public CompletableFuture<CaiMonthlyProfile> getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public CompletableFuture<CaiMonthlyProfile> getMonthlyProfile(String uuid) {
        return JObject.get(new UrlBuilder().monthly().cai().profile(uuid).build()).thenApplyAsync(CaiMonthlyProfile::new);
    }

    @Override
    public CompletableFuture<CaiMonthlyProfile> getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).thenApplyAsync(lb -> lb.getProfiles().get(0));
    }

    @Override
    public CompletableFuture<CaiMonthlyLeaderboard> getMonthlyLeaderboard() {
        return JObject.get(new UrlBuilder().monthly().cai().leaderboard().build()).thenApplyAsync(CaiMonthlyLeaderboard::new);
    }

    @Override
    public CompletableFuture<CaiMonthlyLeaderboard> getMonthlyLeaderboard(int from, int to) {
        return JObject.get(new UrlBuilder().monthly().cai().leaderboard(from, to).build()).thenApplyAsync(CaiMonthlyLeaderboard::new);
    }

}
