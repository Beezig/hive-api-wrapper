package eu.beezig.hiveapi.wrapper.player.games;

import eu.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import eu.beezig.hiveapi.wrapper.monthly.dr.DrMonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.monthly.dr.DrMonthlyProfile;
import eu.beezig.hiveapi.wrapper.player.Profiles;
import eu.beezig.hiveapi.wrapper.player.PvPStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.speedrun.WorldRecord;
import eu.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class DrStats extends PvPStats implements MonthliesReady, Titleable {

    public DrStats(JObject source) {
        super(source);
    }

    public static CompletableFuture<WorldRecord> getWorldRecord(String mapSpeedrunId) {
        return Profiles.speedrun(mapSpeedrunId);
    }

    public long getTrapsActivated() {
        return source.getLong("trapsactivated");
    }

    public long getVictoriesAsRunner() {
        return source.getLong("runnerwins");
    }

    public long getVictoriesAsDeath() {
        return source.getLong("deathwins");
    }

    public long getGamesPlayedAsRunner() {
        return source.getLong("runnergamesplayed");
    }

    public long getGamesPlayedAsDeath() {
        return source.getLong("deathgamesplayed");
    }

    public long getTotalCheckpoints() {
        return source.getLong("totalcheckpoints");
    }

    public Visibility getSelectedVisibility() {
        return Visibility.valueOf(source.getString("visibility"));
    }

    public Map<String, Long> getMapRecords() {
        return source.getJSONObject("maprecords");
    }

    public Map<String, Long> getMapKills() {
        return source.getJSONObject("mapkills");
    }

    public Map<String, Long> getMapDeaths() {
        return source.getJSONObject("mapdeaths");
    }

    public Map<String, Long> getTrapClassKills() {
        return source.getJSONObject("trapclasskills");
    }

    public Map<String, Long> getTrapClassDeaths() {
        return source.getJSONObject("trapclassdeaths");
    }

    @Override
    public CompletableFuture<DrMonthlyProfile> getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public CompletableFuture<DrMonthlyProfile> getMonthlyProfile(String uuid) {
        return JObject.get(new UrlBuilder().monthly().dr().profile(uuid).build()).thenApplyAsync(DrMonthlyProfile::new);
    }

    @Override
    public CompletableFuture<DrMonthlyProfile> getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).thenApplyAsync(lb -> lb.getProfiles().get(0));
    }

    @Override
    public CompletableFuture<DrMonthlyLeaderboard> getMonthlyLeaderboard() {
        return JObject.get(new UrlBuilder().monthly().dr().leaderboard().build()).thenApplyAsync(DrMonthlyLeaderboard::new);
    }

    @Override
    public CompletableFuture<DrMonthlyLeaderboard> getMonthlyLeaderboard(int from, int to) {
        return JObject.get(new UrlBuilder().monthly().dr().leaderboard(from, to).build()).thenApplyAsync(DrMonthlyLeaderboard::new);
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }

    public enum Visibility {
        SHOW_ALL, RUNNERS_AS_GHOST, RUNNERS_INVISIBLE;
    }

}
