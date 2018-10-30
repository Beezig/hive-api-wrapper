package pw.roccodev.beezig.hiveapi.wrapper.player.games.arcade;

import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class CrStats extends PvPStats implements Titleable {

    private LazyObject source;

    public CrStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public CrStats(String username, boolean convertToUUID) {
        super(username, "CR", convertToUUID);
        source = getSource();
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
