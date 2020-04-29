package eu.beezig.hiveapi.wrapper.player.games.arcade;

import eu.beezig.hiveapi.wrapper.player.GameStats;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;

public class RrStats extends GameStats {

    public RrStats(JObject source) {
        super(source);
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
