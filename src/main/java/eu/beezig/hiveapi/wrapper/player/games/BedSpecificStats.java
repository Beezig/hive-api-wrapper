package eu.beezig.hiveapi.wrapper.player.games;

import eu.beezig.hiveapi.wrapper.player.PvPStats;
import eu.beezig.hiveapi.wrapper.player.WinstreaksReady;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

public class BedSpecificStats extends PvPStats implements WinstreaksReady {

    public BedSpecificStats(JObject source) {
        super(source);
    }

    public long getBedsDestroyed() {
        return source.getLong("beds_destroyed");
    }

    public long getTeamsEliminated() {
        return source.getLong("teams_eliminated");
    }

    @Override
    public long getWinstreak() {
        return source.getLong("win_streak");
    }
}
