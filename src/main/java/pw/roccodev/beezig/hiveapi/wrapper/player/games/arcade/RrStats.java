package pw.roccodev.beezig.hiveapi.wrapper.player.games.arcade;

import pw.roccodev.beezig.hiveapi.wrapper.player.GameStats;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class RrStats extends GameStats {

    private LazyObject source;

    public RrStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public RrStats(String username, boolean convertToUUID) {
        super(username, "RR", convertToUUID);
        source = getSource();
    }


    public long getTablesCleared() {
        return source.getLong("tablescleared");
    }

    public long getHighestScore() {
        return source.getLong("highscore");
    }

    @Override
    public long getGamesPlayed() {
        return source.getLong("gamesplayed");
    }

    @Override
    public long getPoints() {
        return source.getLong("points");
    }

    @Override
    public Date getFirstLogin() {
        return new Date(source.getLong("firstlogin") * 1000);
    }
}
