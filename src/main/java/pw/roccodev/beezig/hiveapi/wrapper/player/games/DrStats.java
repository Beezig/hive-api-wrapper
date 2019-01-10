package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.dr.DrMonthlyLeaderboard;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.dr.DrMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.speedrun.WorldRecord;
import pw.roccodev.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Map;

public class DrStats extends PvPStats implements MonthliesReady, Titleable {

    private LazyObject source;

    public DrStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }


    public DrStats(String username, boolean convertToUUID) {
        super(username, "DR", convertToUUID);
        source = getSource();
    }

    public static WorldRecord getWorldRecord(String mapSpeedrunId) {
        return new WorldRecord(new LazyObject(null, new UrlBuilder().speedrun().level(mapSpeedrunId).build()));
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
    public DrMonthlyProfile getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public DrMonthlyProfile getMonthlyProfile(String uuid) {
        return new DrMonthlyProfile(new LazyObject(null, new UrlBuilder().monthly().dr().profile(uuid).build()));
    }

    @Override
    public DrMonthlyProfile getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).getProfiles().get(0);
    }

    @Override
    public DrMonthlyLeaderboard getMonthlyLeaderboard() {
        return new DrMonthlyLeaderboard(new LazyObject(null, new UrlBuilder().monthly().dr().leaderboard().build()));
    }

    @Override
    public DrMonthlyLeaderboard getMonthlyLeaderboard(int from, int to) {
        return new DrMonthlyLeaderboard(new LazyObject(null, new UrlBuilder().monthly().dr().leaderboard(from, to).build()));
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }

    public enum Visibility {
        SHOW_ALL, RUNNERS_AS_GHOST, RUNNERS_INVISIBLE;
    }

}
