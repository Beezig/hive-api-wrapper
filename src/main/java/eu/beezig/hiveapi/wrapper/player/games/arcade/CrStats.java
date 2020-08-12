package eu.beezig.hiveapi.wrapper.player.games.arcade;

import eu.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import eu.beezig.hiveapi.wrapper.monthly.cr.CrMonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.monthly.cr.CrMonthlyProfile;
import eu.beezig.hiveapi.wrapper.player.PvPStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

public class CrStats extends PvPStats implements Titleable, MonthliesReady {

    public CrStats(JObject source) {
        super(source);
    }

    public long getRcCatCount() {
        return source.getLong("rccat_count");
    }

    public long getRcCatKills() {
        return source.getLong("rccat_kills");
    }

    public long getAirstrikeCount() {
        return source.getLong("airstrike_count");
    }

    public long getAirstrikeKills() {
        return source.getLong("airstrike_kills");
    }

    public long getSonicSquidCount() {
        return source.getLong("sonicsquid_count");
    }

    public long getSonicSquidKills() {
        return source.getLong("sonicsquid_kills");
    }

    @Override
    public long getGamesPlayed() {
        return source.getLong("gamesplayed");
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
    public CompletableFuture<CrMonthlyProfile> getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public CompletableFuture<CrMonthlyProfile> getMonthlyProfile(String uuid) {
        return JObject.get(new UrlBuilder().monthly().cr().profile(uuid).build()).thenApplyAsync(CrMonthlyProfile::new);
    }

    @Override
    public CompletableFuture<CrMonthlyProfile> getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).thenApplyAsync(lb -> lb.getProfiles().get(0));
    }

    @Override
    public CompletableFuture<CrMonthlyLeaderboard> getMonthlyLeaderboard() {
        return JObject.get(new UrlBuilder().monthly().cr().leaderboard().build()).thenApplyAsync(CrMonthlyLeaderboard::new);
    }

    @Override
    public CompletableFuture<CrMonthlyLeaderboard> getMonthlyLeaderboard(int from, int to) {
        return JObject.get(new UrlBuilder().monthly().cr().leaderboard(from, to).build()).thenApplyAsync(CrMonthlyLeaderboard::new);
    }
}
