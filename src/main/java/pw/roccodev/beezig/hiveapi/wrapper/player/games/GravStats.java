package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.player.GameStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;
import java.util.Map;

public class GravStats extends GameStats implements Titleable {

    private LazyObject source;

    public GravStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public GravStats(String username, boolean convertToUUID) {
        super(username, "GRAV", convertToUUID);
        source = getSource();
    }

    @Override
    public long getPoints() {
        return source.getLong("points");
    }

    public Map<String, Long> getMapRecords() {
        return source.getJSONObject("maprecords");
    }

    @Override
    public Date getFirstLogin() {
        return new Date(source.getLong("firstlogin") * 1000);
    }

    @Override
    public long getGamesPlayed() {
        return source.getLong("gamesplayed");
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }
}
