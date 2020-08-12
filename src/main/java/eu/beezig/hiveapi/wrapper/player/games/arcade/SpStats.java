package eu.beezig.hiveapi.wrapper.player.games.arcade;

import eu.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import eu.beezig.hiveapi.wrapper.monthly.sp.SpMonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.monthly.sp.SpMonthlyProfile;
import eu.beezig.hiveapi.wrapper.player.PvPStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

public class SpStats extends PvPStats implements Titleable, MonthliesReady {

    public SpStats(JObject source) {
        super(source);
    }

    public long getBlocksDestroyed() {
        return source.getLong("blocksdestroyed");
    }

    public long getEggsFired() {
        return source.getLong("eggsfired");
    }

    public long getTimeAlive() {
        return source.getLong("timealive");
    }

    public boolean hasRainbowEggs() {
        return source.getBoolean("rainboweggs");
    }

    public boolean isSheepUnlocked() {
        return source.getBoolean("sheepunlock");
    }

    public boolean hasShovelUpgrade() {
        return source.getBoolean("shovelupgrade");
    }

    @Override
    public long getKills() {
        return -1;
    }

    @Override
    public long getGamesPlayed() {
        return source.getLong("gamesplayed");
    }

    @Override
    public long getPoints() {
        return source.getLong("points");
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }

    @Override
    public Date getFirstLogin() {
        return new Date(source.getLong("firstlogin") * 1000);
    }

    @Override
    public CompletableFuture<SpMonthlyProfile> getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public CompletableFuture<SpMonthlyProfile> getMonthlyProfile(String uuid) {
        return JObject.get(new UrlBuilder().monthly().sp().profile(uuid).build()).thenApplyAsync(SpMonthlyProfile::new);
    }

    @Override
    public CompletableFuture<SpMonthlyProfile> getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).thenApplyAsync(lb -> lb.getProfiles().get(0));
    }

    @Override
    public CompletableFuture<SpMonthlyLeaderboard> getMonthlyLeaderboard() {
        return JObject.get(new UrlBuilder().monthly().sp().leaderboard().build()).thenApplyAsync(SpMonthlyLeaderboard::new);
    }

    @Override
    public CompletableFuture<SpMonthlyLeaderboard> getMonthlyLeaderboard(int from, int to) {
        return JObject.get(new UrlBuilder().monthly().sp().leaderboard(from, to).build()).thenApplyAsync(SpMonthlyLeaderboard::new);
    }
}
