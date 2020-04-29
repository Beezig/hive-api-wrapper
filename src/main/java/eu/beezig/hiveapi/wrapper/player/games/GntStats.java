package eu.beezig.hiveapi.wrapper.player.games;

import eu.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import eu.beezig.hiveapi.wrapper.monthly.gnt.GntMonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.monthly.gnt.GntMonthlyProfile;
import eu.beezig.hiveapi.wrapper.player.PvPStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

public class GntStats extends PvPStats implements Titleable, MonthliesReady {

    public GntStats(JObject source) {
        super(source);
    }

    @Override
    public Date getFirstLogin() {
        return new Date(source.getLong("firstlogin") * 1000);
    }

    public long getGoldEarned() {
        return source.getLong("gold_earned");
    }

    public long getBeastsSlain() {
        return source.getLong("beasts_slain");
    }

    public long getShutdowns() {
        return source.getLong("shutdowns");
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }

    @Override
    public CompletableFuture<? extends GntMonthlyProfile> getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public CompletableFuture<? extends GntMonthlyProfile> getMonthlyProfile(String uuid) {
        return JObject.get(new UrlBuilder().monthly().gnt().profile(uuid).build()).thenApplyAsync(GntMonthlyProfile::new);
    }

    @Override
    public CompletableFuture<? extends GntMonthlyProfile> getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).thenApplyAsync(lb -> lb.getProfiles().get(0));
    }

    @Override
    public CompletableFuture<? extends GntMonthlyLeaderboard> getMonthlyLeaderboard() {
        return JObject.get(new UrlBuilder().monthly().gnt().leaderboard().build()).thenApplyAsync(GntMonthlyLeaderboard::new);
    }

    @Override
    public CompletableFuture<? extends GntMonthlyLeaderboard> getMonthlyLeaderboard(int from, int to) {
        return JObject.get(new UrlBuilder().monthly().gnt().leaderboard(from, to).build()).thenApplyAsync(GntMonthlyLeaderboard::new);
    }
}
