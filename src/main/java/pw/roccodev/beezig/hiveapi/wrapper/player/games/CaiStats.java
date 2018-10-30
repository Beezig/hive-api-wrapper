package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.player.GameStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class CaiStats extends GameStats implements Titleable {

    private LazyObject source;

    public CaiStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public CaiStats(String username, boolean convertToUUID) {
        super(username, "CAI", convertToUUID);
        source = getSource();
    }

    @Override
    public long getGamesPlayed() {
        return source.getLong("gamesplayed");
    }

    public long getCaptures() {
        return source.getLong("captures");
    }

    public long getCaptured() {
        return source.getLong("captured");
    }

    public long getCatches() {
        return source.getLong("catches");
    }

    public long getCaught() {
        return source.getLong("caught");
    }

    public boolean hasTeamSelector() {
        return source.getBoolean("teamselector");
    }

    public boolean hasCreeperFirework() {
        return source.getBoolean("creeperfirework");
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
