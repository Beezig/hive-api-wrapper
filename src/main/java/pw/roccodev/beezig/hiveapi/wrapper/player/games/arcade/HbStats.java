package pw.roccodev.beezig.hiveapi.wrapper.player.games.arcade;

import pw.roccodev.beezig.hiveapi.wrapper.player.GameStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class HbStats extends GameStats implements Titleable {

    private LazyObject source;

    public HbStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public HbStats(String username, boolean convertToUUID) {
        super(username, "HB", convertToUUID);
        source = getSource();
    }

    @Override
    public long getPoints() {
        return source.getLong("points");
    }

    public String getActiveClass() {
        return source.getString("active_class");
    }

    public long getCaptures() {
        return source.getLong("captures");
    }

    public String[] getUnlockedClasses() {
        return source.getString("unlocked_classes").substring(source.getString("unlocked_classes").length() - 1)
                .split(",");
    }

    @Override
    public long getVictories() {
        return -1;
    }

    @Override
    public Date getFirstLogin() {
        return new Date(source.getLong("firstlogin") * 1000);
    }

    @Override
    public long getGamesPlayed() {
        return -1;
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }
}
