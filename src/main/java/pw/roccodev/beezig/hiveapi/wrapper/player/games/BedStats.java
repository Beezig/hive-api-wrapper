package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.bed.BedMonthlyLeaderboard;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.bed.BedMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.player.WinstreaksReady;
import pw.roccodev.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

public class BedStats extends PvPStats implements WinstreaksReady, MonthliesReady, Titleable {

    private LazyObject source;

    public BedStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public BedStats(String username, String shortcode, boolean convertToUUID) {
        super(username, shortcode, convertToUUID);
        source = getSource();
    }

    public BedStats(String username, String shortcode) {
        this(username, shortcode, false);
    }

    public BedStats(String username, boolean convertToUUID) {
       this(username, "BED", convertToUUID);
    }

    public long getBedsDestroyed() {
        return source.getLong("beds_destroyed");
    }

    public long getTeamsEliminated() {
        return source.getLong("teams_eliminated");
    }

    @Override
    public long getWinstreak() {
        return source.getLong("win_streak");
    }

    @Override
    public BedMonthlyProfile getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public BedMonthlyProfile getMonthlyProfile(String uuid) {
        return new BedMonthlyProfile(new LazyObject(null, new UrlBuilder().monthly().bedwars().profile(uuid).build()));
    }

    @Override
    public BedMonthlyProfile getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).getProfiles().get(0);
    }

    @Override
    public BedMonthlyLeaderboard getMonthlyLeaderboard() {
        return new BedMonthlyLeaderboard(new LazyObject(null, new UrlBuilder().monthly().bedwars().leaderboard().build()));
    }

    @Override
    public BedMonthlyLeaderboard getMonthlyLeaderboard(int from, int to) {
        return new BedMonthlyLeaderboard(new LazyObject(null, new UrlBuilder().monthly().bedwars().leaderboard(from, to).build()));
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }
}
