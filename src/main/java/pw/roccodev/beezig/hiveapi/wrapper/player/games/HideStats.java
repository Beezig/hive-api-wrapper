package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;
import java.util.Map;

public class HideStats extends PvPStats implements Titleable {

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
}
