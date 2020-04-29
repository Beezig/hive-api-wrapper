package eu.beezig.hiveapi.wrapper.player.games;

import eu.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import eu.beezig.hiveapi.wrapper.monthly.bp.BpMonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.monthly.bp.BpMonthlyProfile;
import eu.beezig.hiveapi.wrapper.player.GameStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

public class BpStats extends GameStats implements Titleable, MonthliesReady {

    public BpStats(JObject source) {
        super(source);
    }

    public long getPlacings() {
        return source.getLong("total_placings");
    }

    public long getEliminations() {
        return source.getLong("total_eliminations");
    }

    public String getSelectedBling() {
        return source.getString("selected_bling");
    }

    @Override
    public Date getLastLogin() {
        return null;
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }

    @Override
    public CompletableFuture<BpMonthlyProfile> getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public CompletableFuture<BpMonthlyProfile> getMonthlyProfile(String uuid) {
        return JObject.get(new UrlBuilder().monthly().bp().profile(uuid).build()).thenApplyAsync(BpMonthlyProfile::new);
    }

    @Override
    public CompletableFuture<BpMonthlyProfile> getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).thenApplyAsync(lb -> lb.getProfiles().get(0));
    }

    @Override
    public CompletableFuture<BpMonthlyLeaderboard> getMonthlyLeaderboard() {
        return JObject.get(new UrlBuilder().monthly().bp().leaderboard().build()).thenApplyAsync(BpMonthlyLeaderboard::new);
    }

    @Override
    public CompletableFuture<BpMonthlyLeaderboard> getMonthlyLeaderboard(int from, int to) {
        return JObject.get(new UrlBuilder().monthly().bp().leaderboard(from, to).build()).thenApplyAsync(BpMonthlyLeaderboard::new);
    }
}
