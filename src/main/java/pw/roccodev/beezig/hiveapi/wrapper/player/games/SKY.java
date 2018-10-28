package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

public class SKY extends PvPStats {

    private LazyObject source;

    public SKY(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }


    public SKY(String username, boolean convertToUUID) {
        super(username, "SKY", convertToUUID);
        source = getSource();
    }


    @Override
    public long getGamesPlayed() {
        return source.getLong("gamesplayed");
    }

    public long getMostPoints() {
        return source.getLong("most_points");
    }

    public long getTimeAlive() {
        return source.getLong("timealive");
    }

}
