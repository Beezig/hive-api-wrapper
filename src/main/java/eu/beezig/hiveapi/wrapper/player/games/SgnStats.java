package eu.beezig.hiveapi.wrapper.player.games;

import eu.beezig.hiveapi.wrapper.player.PvPStats;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

public class SgnStats extends PvPStats {

    public SgnStats(JObject source) {
        super(source);
    }

    public long getMostPoints() {
        return source.getLong("most_points");
    }

    public long getCratesOpened() {
        return source.getLong("crates_opened");
    }

    public long getDeathmatches() {
        return source.getLong("deathmatches");
    }

    public String[] getRecentGames() {
        return (String[]) source.getJSONArray("recentgames").toArray(new String[0]);
    }

}
