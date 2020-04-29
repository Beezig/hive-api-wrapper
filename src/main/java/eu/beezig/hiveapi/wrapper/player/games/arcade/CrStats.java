package eu.beezig.hiveapi.wrapper.player.games.arcade;

import eu.beezig.hiveapi.wrapper.player.PvPStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;

public class CrStats extends PvPStats implements Titleable {

    public CrStats(JObject source) {
        super(source);
    }

    public long getRcCatCount() {
        return source.getLong("rccat_count");
    }

    public long getRcCatKills() {
        return source.getLong("rccat_kills");
    }

    public long getAirstrikeCount() {
        return source.getLong("airstrike_count");
    }

    public long getAirstrikeKills() {
        return source.getLong("airstrike_kills");
    }

    public long getSonicSquidCount() {
        return source.getLong("sonicsquid_count");
    }

    public long getSonicSquidKills() {
        return source.getLong("sonicsquid_kills");
    }

    @Override
    public long getGamesPlayed() {
        return source.getLong("gamesplayed");
    }

    @Override
    public Date getFirstLogin() {
        return new Date(source.getLong("firstlogin") * 1000);
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }
}
