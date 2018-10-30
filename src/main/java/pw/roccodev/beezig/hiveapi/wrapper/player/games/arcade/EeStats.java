package pw.roccodev.beezig.hiveapi.wrapper.player.games.arcade;

import pw.roccodev.beezig.hiveapi.wrapper.player.GameStats;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class EeStats extends GameStats {

    private LazyObject source;

    public EeStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public EeStats(String username, boolean convertToUUID) {
        super(username, "EE", convertToUUID);
        source = getSource();
    }

    @Override
    public long getPoints() {
        return source.getLong("points");
    }

    public long getLeaps() {
        return source.getLong("leaps");
    }

    @Override
    public Date getFirstLogin() {
        return new Date(source.getLong("firstlogin") * 1000);
    }

    @Override
    public long getGamesPlayed() {
        return source.getLong("gamesplayed");
    }

}
