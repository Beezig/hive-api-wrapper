package eu.beezig.hiveapi.wrapper.player.games;

import eu.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import eu.beezig.hiveapi.wrapper.monthly.bed.BedMonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.monthly.bed.BedMonthlyProfile;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.concurrent.CompletableFuture;

public class BedStats extends BedSpecificStats implements MonthliesReady, Titleable {

    public BedStats(JObject source) {
        super(source);
    }

    @Override
    public CompletableFuture<BedMonthlyProfile> getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public CompletableFuture<BedMonthlyProfile> getMonthlyProfile(String uuid) {
        return JObject.get(new UrlBuilder().monthly().bedwars().profile(uuid).build()).thenApplyAsync(BedMonthlyProfile::new);
    }

    @Override
    public CompletableFuture<BedMonthlyProfile> getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).thenApplyAsync(lb -> lb.getProfiles().get(0));
    }

    @Override
    public CompletableFuture<BedMonthlyLeaderboard> getMonthlyLeaderboard() {
        return JObject.get(new UrlBuilder().monthly().bedwars().leaderboard().build()).thenApplyAsync(BedMonthlyLeaderboard::new);
    }

    @Override
    public CompletableFuture<BedMonthlyLeaderboard> getMonthlyLeaderboard(int from, int to) {
        return JObject.get(new UrlBuilder().monthly().bedwars().leaderboard(from, to).build()).thenApplyAsync(BedMonthlyLeaderboard::new);
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }
}
