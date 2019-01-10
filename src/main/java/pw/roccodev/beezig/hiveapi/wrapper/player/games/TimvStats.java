package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.timv.TimvMonthlyLeaderboard;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.timv.TimvMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.player.GameStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class TimvStats extends GameStats implements MonthliesReady, Titleable {

    private LazyObject source;

    public TimvStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }


    public TimvStats(String username, boolean convertToUUID) {
        super(username, "TIMV", convertToUUID);
        source = getSource();
    }

    public long getKarma() {
        return getPoints();
    }

    public long getRolePoints() {
        return source.getLong("role_points");
    }

    public long getInnocentPoints() {
        return source.getLong("i_points");
    }

    public long getDetectivePoints() {
        return source.getLong("d_points");
    }

    public long getTraitorPoints() {
        return source.getLong("t_points");
    }

    public long getMostPoints() {
        return source.getLong("most_points");
    }

    @Override
    public Date getFirstLogin() {
        return null;
    }

    @Override
    public Date getCachedAt() {
        return null;
    }

    @Override
    public long getVictories() {
        return -1;
    }

    @Override
    public long getGamesPlayed() {
        return -1;
    }

    public boolean hasDetectiveStick() {
        return source.getBoolean("detectivebook");
    }

    @Override
    public TimvMonthlyProfile getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public TimvMonthlyProfile getMonthlyProfile(String uuid) {
        return new TimvMonthlyProfile(new LazyObject(null, new UrlBuilder().monthly().timv().profile(uuid).build()));
    }

    @Override
    public TimvMonthlyProfile getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).getProfiles().get(0);
    }

    @Override
    public TimvMonthlyLeaderboard getMonthlyLeaderboard() {
        return new TimvMonthlyLeaderboard(new LazyObject(null, new UrlBuilder().monthly().timv().leaderboard().build()));
    }

    @Override
    public TimvMonthlyLeaderboard getMonthlyLeaderboard(int from, int to) {
        return new TimvMonthlyLeaderboard(new LazyObject(null, new UrlBuilder().monthly().timv().leaderboard(from, to).build()));
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }
}
