package pw.roccodev.beezig.hiveapi.wrapper.player.games.arcade;

import pw.roccodev.beezig.hiveapi.wrapper.player.Achievement;
import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.List;

public class BdStats extends PvPStats implements Titleable {

    private LazyObject source;

    public BdStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public BdStats(String username, boolean convertToUUID) {
        super(username, "BD", convertToUUID);
        source = getSource();
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
