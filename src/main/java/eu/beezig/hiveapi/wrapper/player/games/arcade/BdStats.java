package eu.beezig.hiveapi.wrapper.player.games.arcade;

import eu.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import eu.beezig.hiveapi.wrapper.monthly.bd.BdMonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.monthly.bd.BdMonthlyProfile;
import eu.beezig.hiveapi.wrapper.player.Achievement;
import eu.beezig.hiveapi.wrapper.player.PvPStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BdStats extends PvPStats implements Titleable, MonthliesReady {

    public BdStats(JObject source) {
        super(source);
    }

    public long getEnergyCollected() {
        return source.getLong("energy_collected");
    }

    public long getBatteriesCharged() {
        return source.getLong("batteries_charged");
    }

    @Override
    public List<Achievement> getAchievements() {
        return null;
    }

    @Override
    public List<Achievement> getUnlockedAchievements() {
        return null;
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }
    @Override
    public CompletableFuture<BdMonthlyProfile> getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public CompletableFuture<BdMonthlyProfile> getMonthlyProfile(String uuid) {
        return JObject.get(new UrlBuilder().monthly().bd().profile(uuid).build()).thenApplyAsync(BdMonthlyProfile::new);
    }

    @Override
    public CompletableFuture<BdMonthlyProfile> getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).thenApplyAsync(lb -> lb.getProfiles().get(0));
    }

    @Override
    public CompletableFuture<BdMonthlyLeaderboard> getMonthlyLeaderboard() {
        return JObject.get(new UrlBuilder().monthly().bd().leaderboard().build()).thenApplyAsync(BdMonthlyLeaderboard::new);
    }

    @Override
    public CompletableFuture<BdMonthlyLeaderboard> getMonthlyLeaderboard(int from, int to) {
        return JObject.get(new UrlBuilder().monthly().bd().leaderboard(from, to).build()).thenApplyAsync(BdMonthlyLeaderboard::new);
    }
    
}
