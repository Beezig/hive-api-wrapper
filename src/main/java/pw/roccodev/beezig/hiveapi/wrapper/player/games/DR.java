package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

public class DR extends PvPStats {

    private LazyObject source;

    public DR(String usernameOrUUID) {
        super(usernameOrUUID, "BED");
        source = getSource();
    }

    public long getTrapsActivated() {
        return source.getLong("trapsactivated");
    }

    public long getVictoriesAsRunner() {
        return source.getLong("runnerwins");
    }

    public long getVictoriesAsDeath() {
        return source.getLong("deathwins");
    }

    public long getGamesPlayedAsRunner() {
        return source.getLong("runnergamesplayed");
    }

    public long getGamesPlayedAsDeath() {
        return source.getLong("deathgamesplayed");
    }

    public long getTotalCheckpoints() {
        return source.getLong("totalcheckpoints");
    }

}
