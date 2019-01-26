package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.bp.BpMonthlyLeaderboard;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.bp.BpMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.player.GameStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class BpStats extends GameStats implements Titleable, MonthliesReady {

    private LazyObject source;

    public BpStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public BpStats(String username, boolean convertToUUID) {
        super(username, "BP", convertToUUID);
        source = getSource();
    }

    public long getPlacings() {
        return source.getLong("total_placings");
    }

    public long getEliminations() {
        return source.getLong("total_eliminations");
    }

    public String getSelectedBling() {
        return source.getString("selected_bling");
    }

    @Override
    public Date getLastLogin() {
        return null;
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }

    @Override
    public BpMonthlyProfile getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public BpMonthlyProfile getMonthlyProfile(String uuid) {
        return new BpMonthlyProfile(new LazyObject(null, new UrlBuilder().monthly().bp().profile(uuid).build()));
    }

    @Override
    public BpMonthlyProfile getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).getProfiles().get(0);
    }

    @Override
    public BpMonthlyLeaderboard getMonthlyLeaderboard() {
        return new BpMonthlyLeaderboard(new LazyObject(null, new UrlBuilder().monthly().bp().leaderboard().build()));
    }

    @Override
    public BpMonthlyLeaderboard getMonthlyLeaderboard(int from, int to) {
        return new BpMonthlyLeaderboard(new LazyObject(null, new UrlBuilder().monthly().bp().leaderboard(from, to).build()));
    }
}
