package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.gnt.GntMonthlyLeaderboard;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.gnt.GntMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class GntStats extends PvPStats implements Titleable, MonthliesReady {

    private LazyObject source;

    public GntStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public GntStats(String username, boolean convertToUUID) {
        this(username, "GNT", convertToUUID);
    }

    GntStats(String username, String shortcode, boolean convertToUUID) {
        super(username, shortcode, convertToUUID);
        source = getSource();
    }

    @Override
    public Date getFirstLogin() {
        return new Date(source.getLong("firstlogin") * 1000);
    }

    public long getGoldEarned() {
        return source.getLong("gold_earned");
    }

    public long getBeastsSlain() {
        return source.getLong("beasts_slain");
    }

    public long getShutdowns() {
        return source.getLong("shutdowns");
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }

    @Override
    public GntMonthlyProfile getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public GntMonthlyProfile getMonthlyProfile(String uuid) {
        return new GntMonthlyProfile(new LazyObject(null, new UrlBuilder().monthly().gnt().profile(uuid).build()));
    }

    @Override
    public GntMonthlyProfile getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).getProfiles().get(0);
    }

    @Override
    public GntMonthlyLeaderboard getMonthlyLeaderboard() {
        return new GntMonthlyLeaderboard(new LazyObject(null, new UrlBuilder().monthly().gnt().leaderboard().build()));
    }

    @Override
    public GntMonthlyLeaderboard getMonthlyLeaderboard(int from, int to) {
        return new GntMonthlyLeaderboard(new LazyObject(null, new UrlBuilder().monthly().gnt().leaderboard(from, to).build()));
    }
}
