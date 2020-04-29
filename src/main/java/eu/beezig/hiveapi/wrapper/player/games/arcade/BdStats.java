package eu.beezig.hiveapi.wrapper.player.games.arcade;

import eu.beezig.hiveapi.wrapper.player.Achievement;
import eu.beezig.hiveapi.wrapper.player.PvPStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.List;

public class BdStats extends PvPStats implements Titleable {

    public BdStats(JObject source) {
        super(source);
    }

    public long getEnergyCollected() {
        return source.getLong("energy_collected");
    }

    public long getBatteriesCharged() {
        return source.getLong("batteries_charged");
    }

    @Override
    public List<Achievement> getAchievements() {
        return null;
    }

    @Override
    public List<Achievement> getUnlockedAchievements() {
        return null;
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }
}
