package eu.beezig.hiveapi.wrapper.player.games.arcade;

import eu.beezig.hiveapi.wrapper.player.PvPStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;

public class SpStats extends PvPStats implements Titleable {

    public SpStats(JObject source) {
        super(source);
    }

    public long getBlocksDestroyed() {
        return source.getLong("blocksdestroyed");
    }

    public long getEggsFired() {
        return source.getLong("eggsfired");
    }

    public long getTimeAlive() {
        return source.getLong("timealive");
    }

    public boolean hasRainbowEggs() {
        return source.getBoolean("rainboweggs");
    }

    public boolean isSheepUnlocked() {
        return source.getBoolean("sheepunlock");
    }

    public boolean hasShovelUpgrade() {
        return source.getBoolean("shovelupgrade");
    }

    @Override
    public long getKills() {
        return -1;
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
