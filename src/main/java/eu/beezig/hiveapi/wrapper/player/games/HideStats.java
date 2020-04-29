package eu.beezig.hiveapi.wrapper.player.games;

import eu.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import eu.beezig.hiveapi.wrapper.monthly.hide.HideMonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.monthly.hide.HideMonthlyProfile;
import eu.beezig.hiveapi.wrapper.player.PvPStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class HideStats extends PvPStats implements Titleable, MonthliesReady {

    public HideStats(JObject source) {
        super(source);
    }

    @Override
    public long getGamesPlayed() {
        return source.getLong("gamesplayed");
    }

    @Override
    public Date getFirstLogin() {
        return new Date(source.getLong("firstlogin") * 1000);
    }

    public long getKillsAsSeeker() {
        return source.getLong("seekerkills");
    }

    public long getKillsAsHider() {
        return source.getLong("hiderkills");
    }

    public Map<String, Long> getBlockLevels() {
        return source.getJSONObject("blockExperience");
    }

    public Map<String, Long> getBlockExperience() {
        return source.getJSONObject("rawBlockExperience");
    }

    @Override
    public long getKills() {
        return getKillsAsHider() + getKillsAsSeeker();
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }

    @Override
    public Date getLastLogin() {
        return new Date(source.getLong("lastlogin")); // Already in milliseconds
    }

    @Override
    public CompletableFuture<HideMonthlyProfile> getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public CompletableFuture<HideMonthlyProfile> getMonthlyProfile(String uuid) {
        return JObject.get(new UrlBuilder().monthly().hide().profile(uuid).build()).thenApplyAsync(HideMonthlyProfile::new);
    }

    @Override
    public CompletableFuture<HideMonthlyProfile> getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).thenApplyAsync(lb -> lb.getProfiles().get(0));
    }

    @Override
    public CompletableFuture<HideMonthlyLeaderboard> getMonthlyLeaderboard() {
        return JObject.get(new UrlBuilder().monthly().hide().leaderboard().build()).thenApplyAsync(HideMonthlyLeaderboard::new);
    }

    @Override
    public CompletableFuture<HideMonthlyLeaderboard> getMonthlyLeaderboard(int from, int to) {
        return JObject.get(new UrlBuilder().monthly().hide().leaderboard(from, to).build()).thenApplyAsync(HideMonthlyLeaderboard::new);
    }
}
