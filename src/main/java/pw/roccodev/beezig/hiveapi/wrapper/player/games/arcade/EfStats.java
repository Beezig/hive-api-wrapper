package pw.roccodev.beezig.hiveapi.wrapper.player.games.arcade;

import pw.roccodev.beezig.hiveapi.wrapper.player.GameStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class EfStats extends GameStats implements Titleable {

    private LazyObject source;

    public EfStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public EfStats(String username, boolean convertToUUID) {
        super(username, "EF", convertToUUID);
        source = getSource();
    }

    @Override
    public long getPoints() {
        return source.getLong("points");
    }

    public long getOutlived() {
        return source.getLong("outlived");
    }

    public long getBlocksActivated() {
        return source.getLong("blocksactivated");
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
