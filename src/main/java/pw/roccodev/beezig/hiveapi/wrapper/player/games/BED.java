package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.MonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.bed.BedMonthlyLeaderboard;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.bed.BedMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.WinstreaksReady;
import pw.roccodev.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

public class BED extends PvPStats implements WinstreaksReady, MonthliesReady {

    private LazyObject source;

    public BED(String usernameOrUUID) {
        this(usernameOrUUID, "BED");
    }

    public BED(String usernameOrUUID, String shortcode) {
        super(usernameOrUUID, shortcode);
        source = getSource();
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
    public MonthlyProfile getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace - 1, humanPlace).getProfiles().get(0);
    }

    @Override
    public BedMonthlyLeaderboard getMonthlyLeaderboard() {
        return new BedMonthlyLeaderboard(new LazyObject(null, new UrlBuilder().monthly().bedwars().leaderboard().build()));
    }

    @Override
    public BedMonthlyLeaderboard getMonthlyLeaderboard(int from, int to) {
        return new BedMonthlyLeaderboard(new LazyObject(null, new UrlBuilder().monthly().bedwars().leaderboard(from, to).build()));
    }
}
