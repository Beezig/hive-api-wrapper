package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.sky.SkyMonthlyLeaderboard;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.sky.SkyMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

public class SkyStats extends PvPStats implements Titleable, MonthliesReady {

    private LazyObject source;

    public SkyStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }


    public SkyStats(String username, boolean convertToUUID) {
        super(username, "SKY", convertToUUID);
        source = getSource();
    }


    @Override
    public long getGamesPlayed() {
        return source.getLong("gamesplayed");
    }

    public long getMostPoints() {
        return source.getLong("most_points");
    }

    public long getTimeAlive() {
        return source.getLong("timealive");
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }

    @Override
    public SkyMonthlyProfile getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public SkyMonthlyProfile getMonthlyProfile(String uuid) {
        return new SkyMonthlyProfile(new LazyObject(null, new UrlBuilder().monthly().sky().profile(uuid).build()));
    }

    @Override
    public SkyMonthlyProfile getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).getProfiles().get(0);
    }

    @Override
    public SkyMonthlyLeaderboard getMonthlyLeaderboard() {
        return new SkyMonthlyLeaderboard(new LazyObject(null, new UrlBuilder().monthly().sky().leaderboard().build()));
    }

    @Override
    public SkyMonthlyLeaderboard getMonthlyLeaderboard(int from, int to) {
        return new SkyMonthlyLeaderboard(new LazyObject(null, new UrlBuilder().monthly().sky().leaderboard(from, to).build()));
    }

}
