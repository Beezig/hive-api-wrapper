package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

public class SgnStats extends PvPStats {

    private LazyObject source;

    public SgnStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }


    public SgnStats(String username, boolean convertToUUID) {
        super(username, "SGN", convertToUUID);
        source = getSource();
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
