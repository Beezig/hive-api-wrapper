package pw.roccodev.beezig.hiveapi.wrapper.player.games.arcade;

import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class SlapStats extends PvPStats implements Titleable {

    private LazyObject source;

    public SlapStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public SlapStats(String username, boolean convertToUUID) {
        super(username, "SLAP", convertToUUID);
        source = getSource();
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
    public String getTitle() {
        return source.getString("title");
    }

    @Override
    public Date getFirstLogin() {
        return new Date(source.getLong("firstlogin") * 1000);
    }

}
