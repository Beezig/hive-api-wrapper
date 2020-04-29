package eu.beezig.hiveapi.wrapper.player.games;

import eu.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import eu.beezig.hiveapi.wrapper.monthly.gnt.GntMonthlyProfile;
import eu.beezig.hiveapi.wrapper.monthly.gnt.GntmMonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.monthly.gnt.GntmMonthlyProfile;
import eu.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.concurrent.CompletableFuture;

public class GntmStats extends GntStats implements MonthliesReady {

    public GntmStats(JObject source) {
        super(source);
    }

    @Override
    public CompletableFuture<GntMonthlyProfile> getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public CompletableFuture<GntMonthlyProfile> getMonthlyProfile(String uuid) {
        return JObject.get(new UrlBuilder().monthly().gntm().profile(uuid).build()).thenApplyAsync(GntmMonthlyProfile::new);
    }

    @Override
    public CompletableFuture<GntMonthlyProfile> getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).thenApplyAsync(lb -> lb.getProfiles().get(0));
    }

    @Override
    public CompletableFuture<GntmMonthlyLeaderboard> getMonthlyLeaderboard() {
        return JObject.get(new UrlBuilder().monthly().gntm().leaderboard().build()).thenApplyAsync(GntmMonthlyLeaderboard::new);
    }

    @Override
    public CompletableFuture<GntmMonthlyLeaderboard> getMonthlyLeaderboard(int from, int to) {
        return JObject.get(new UrlBuilder().monthly().gntm().leaderboard(from, to).build()).thenApplyAsync(GntmMonthlyLeaderboard::new);
    }
}
