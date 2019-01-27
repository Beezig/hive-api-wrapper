package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.MonthliesReady;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.hide.HideMonthlyLeaderboard;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.hide.HideMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;
import java.util.Map;

public class HideStats extends PvPStats implements Titleable, MonthliesReady {

    private LazyObject source;

    public HideStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public HideStats(String username, boolean convertToUUID) {
        super(username, "HIDE", convertToUUID);
        source = getSource();
    }

    @Override
    public long getGamesPlayed() {
        return source.getLong("gamesplayed");
    }

    @Override
    public Date getFirstLogin() {
        return new Date(source.getLong("firstlogin") * 1000);
    }

    public long getKillsAsSeeker() {
        return source.getLong("seekerkills");
    }

    public long getKillsAsHider() {
        return source.getLong("hiderkills");
    }

    public Map<String, Long> getBlockLevels() {
        return source.getJSONObject("blockExperience");
    }

    public Map<String, Long> getBlockExperience() {
        return source.getJSONObject("rawBlockExperience");
    }

    @Override
    public long getKills() {
        return getKillsAsHider() + getKillsAsSeeker();
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }

    @Override
    public Date getLastLogin() {
        return new Date(source.getLong("lastlogin")); // Already in milliseconds
    }

    @Override
    public HideMonthlyProfile getMonthlyProfile() {
        return getMonthlyProfile(getUUID());
    }

    @Override
    public HideMonthlyProfile getMonthlyProfile(String uuid) {
        return new HideMonthlyProfile(new LazyObject(null, new UrlBuilder().monthly().hide().profile(uuid).build()));
    }

    @Override
    public HideMonthlyProfile getMonthlyProfile(int humanPlace) {
        return getMonthlyLeaderboard(humanPlace, humanPlace).getProfiles().get(0);
    }

    @Override
    public HideMonthlyLeaderboard getMonthlyLeaderboard() {
        return new HideMonthlyLeaderboard(new LazyObject(null, new UrlBuilder().monthly().hide().leaderboard().build()));
    }

    @Override
    public HideMonthlyLeaderboard getMonthlyLeaderboard(int from, int to) {
        return new HideMonthlyLeaderboard(new LazyObject(null, new UrlBuilder().monthly().hide().leaderboard(from, to).build()));
    }
}
