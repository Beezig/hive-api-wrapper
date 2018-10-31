package pw.roccodev.beezig.hiveapi.wrapper.player.games.arcade;

import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

public class PmkStats extends PvPStats implements Titleable {

    private LazyObject source;

    public PmkStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public PmkStats(String username, boolean convertToUUID) {
        super(username, "PMK", convertToUUID);
        source = getSource();
    }


    public long getInfections() {
        return source.getLong("infections");
    }

    @Override
    public long getDeaths() {
        return getInfections();
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }
}
