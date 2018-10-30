package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.player.GameStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class BpStats extends GameStats implements Titleable {

    private LazyObject source;

    public BpStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public BpStats(String username, boolean convertToUUID) {
        super(username, "BP", convertToUUID);
        source = getSource();
    }

    public long getPlacings() {
        return source.getLong("total_placings");
    }

    public long getEliminations() {
        return source.getLong("total_eliminations");
    }

    public String getSelectedBling() {
        return source.getString("selected_bling");
    }

    @Override
    public Date getLastLogin() {
        return null;
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }
}
