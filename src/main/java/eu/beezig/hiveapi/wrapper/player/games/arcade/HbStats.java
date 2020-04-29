package eu.beezig.hiveapi.wrapper.player.games.arcade;

import eu.beezig.hiveapi.wrapper.player.GameStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;

public class HbStats extends GameStats implements Titleable {

    public HbStats(JObject source) {
        super(source);
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
