package eu.beezig.hiveapi.wrapper.player.games;

import eu.beezig.hiveapi.wrapper.player.PvPStats;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;

public class SgStats extends PvPStats {

    public SgStats(JObject source) {
        super(source);
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
