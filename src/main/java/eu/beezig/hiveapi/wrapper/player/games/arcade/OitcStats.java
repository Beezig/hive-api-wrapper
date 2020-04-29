package eu.beezig.hiveapi.wrapper.player.games.arcade;

import eu.beezig.hiveapi.wrapper.player.PvPStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;

public class OitcStats extends PvPStats implements Titleable {

    public OitcStats(JObject source) {
        super(source);
    }

    public boolean isCupidUnlocked() {
        return source.getBoolean("cupidunlock");
    }

    public boolean isRainbowUnlocked() {
        return source.getBoolean("rainbowunlock");
    }

    public boolean isMusicUnlocked() {
        return source.getBoolean("musicunlock");
    }

    public boolean isHerobrineUnlocked() {
        return source.getBoolean("herobrineunlock");
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
