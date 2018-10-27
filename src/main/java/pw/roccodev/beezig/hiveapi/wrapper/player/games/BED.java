package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.WinstreaksReady;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

public class BED extends PvPStats implements WinstreaksReady {

    private LazyObject source;

    public BED(String usernameOrUUID) {
        this(usernameOrUUID, "BED");
    }

    public BED(String usernameOrUUID, String shortcode) {
        super(usernameOrUUID, shortcode);
        source = getSource();
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
