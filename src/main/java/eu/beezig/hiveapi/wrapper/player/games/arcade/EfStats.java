package eu.beezig.hiveapi.wrapper.player.games.arcade;

import eu.beezig.hiveapi.wrapper.player.GameStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;

public class EfStats extends GameStats implements Titleable {

    public EfStats(JObject source) {
        super(source);
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
