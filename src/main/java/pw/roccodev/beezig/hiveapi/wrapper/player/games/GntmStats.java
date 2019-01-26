package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.gnt.GntmMonthlyLeaderboard;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.gnt.GntmMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

public class GntmStats extends GntStats implements MonthliesReady {

    public GntmStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public GntmStats(String username, boolean convertToUUID) {
        super(username, "GNTM", convertToUUID);
    }

    @Override
    public GntmMonthlyProfile getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public GntmMonthlyProfile getMonthlyProfile(String uuid) {
        return new GntmMonthlyProfile(new LazyObject(null, new UrlBuilder().monthly().gntm().profile(uuid).build()));
    }

    @Override
    public GntmMonthlyProfile getMonthlyProfile(int humanPlace) {
        return (GntmMonthlyProfile) getMonthlyLeaderboard(humanPlace, humanPlace).getProfiles().get(0);
    }

    @Override
    public GntmMonthlyLeaderboard getMonthlyLeaderboard() {
        return new GntmMonthlyLeaderboard(new LazyObject(null, new UrlBuilder().monthly().gntm().leaderboard().build()));
    }

    @Override
    public GntmMonthlyLeaderboard getMonthlyLeaderboard(int from, int to) {
        return new GntmMonthlyLeaderboard(new LazyObject(null, new UrlBuilder().monthly().gntm().leaderboard(from, to).build()));
    }
}
