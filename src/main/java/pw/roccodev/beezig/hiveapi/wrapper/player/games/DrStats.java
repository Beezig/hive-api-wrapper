package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.maxthat.dr.DrMonthlyLeaderboard;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.maxthat.dr.DrMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

public class DrStats extends PvPStats implements MonthliesReady {

    private LazyObject source;

    public DrStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }


    public DrStats(String username, boolean convertToUUID) {
        super(username, "DR", convertToUUID);
        source = getSource();
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

    @Override
    public DrMonthlyProfile getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public DrMonthlyProfile getMonthlyProfile(String uuid) {
        return getMonthlyLeaderboard().getProfiles().stream()
                .filter(profile -> profile.getUUID().equals(uuid)).findAny().orElse(null);
    }

    @Override
    public DrMonthlyProfile getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard().getProfiles().stream()
                .filter(profile -> profile.getPlace() == humanPlace - 1).findAny().orElse(null);
    }

    @Override
    public DrMonthlyLeaderboard getMonthlyLeaderboard() {
        return new DrMonthlyLeaderboard(new LazyObject(null, new UrlBuilder().monthly().dr().build()));
    }

    @Override
    public DrMonthlyLeaderboard getMonthlyLeaderboard(int from, int to) {
        return (DrMonthlyLeaderboard) getMonthlyLeaderboard().filter(profile -> profile.getPlace() >= from && profile.getPlace() < to);
    }

    public enum Visibility {
        SHOW_ALL, RUNNERS_AS_GHOST, RUNNERS_INVISIBLE;
    }

}
