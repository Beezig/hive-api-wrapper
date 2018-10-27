package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class TIMV extends PvPStats {

    private LazyObject source;

    public TIMV(String usernameOrUUID) {
        super(usernameOrUUID, "TIMV");
        source = getSource();
    }

    public long getKarma() {
        return getPoints();
    }

    public long getRolePoints() {
        return source.getLong("role_points");
    }

    public long getInnocentPoints() {
        return source.getLong("i_points");
    }

    public long getDetectivePoints() {
        return source.getLong("d_points");
    }

    public long getTraitorPoints() {
        return source.getLong("t_points");
    }

    public long getMostPoints() {
        return source.getLong("most_points");
    }

    @Override
    public Date getFirstLogin() {
        return null;
    }

    @Override
    public Date getCachedAt() {
        return null;
    }

    @Override
    public long getVictories() {
        return -1;
    }

    @Override
    public long getGamesPlayed() {
        return -1;
    }

    public boolean hasDetectiveStick() {
        return source.getBoolean("detectivebook");
    }

}
