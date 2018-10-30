package pw.roccodev.beezig.hiveapi.wrapper.player.games.arcade;

import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class OitcStats extends PvPStats implements Titleable {

    private LazyObject source;

    public OitcStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public OitcStats(String username, boolean convertToUUID) {
        super(username, "OITC", convertToUUID);
        source = getSource();
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
