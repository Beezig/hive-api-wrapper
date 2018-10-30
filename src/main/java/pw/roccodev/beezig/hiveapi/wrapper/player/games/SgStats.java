package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class SgStats extends PvPStats {

    private LazyObject source;

    public SgStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }


    public SgStats(String username, boolean convertToUUID) {
        super(username, "SG", convertToUUID);
        source = getSource();
    }

    public long getMostPoints() {
        return source.getLong("most_points");
    }

    public long getCratesOpened() {
        return source.getLong("cratesopened");
    }

    public long getDeathmatches() {
        return source.getLong("deathmatches");
    }

    public String[] getRecentGames() {
        return (String[]) source.getJSONArray("recentgames").toArray(new String[0]);
    }

    public long getTimeAlive() {
        return source.getLong("timealive");
    }

    public Date getFirstWin() {
        return new Date(source.getLong("firstwinday") * 1000);
    }

}
