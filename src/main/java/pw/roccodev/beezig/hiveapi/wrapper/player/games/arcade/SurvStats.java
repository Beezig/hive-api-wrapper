package pw.roccodev.beezig.hiveapi.wrapper.player.games.arcade;

import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

public class SurvStats extends PvPStats implements Titleable {

    private LazyObject source;

    public SurvStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public SurvStats(String username, boolean convertToUUID) {
        super(username, "SURV", convertToUUID);
        source = getSource();
    }

    public long getGeneratorsPowered() {
        return source.getLong("generators_powered");
    }

    public long getLootedCrates() {
        return source.getLong("looted_crates");
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }
}
