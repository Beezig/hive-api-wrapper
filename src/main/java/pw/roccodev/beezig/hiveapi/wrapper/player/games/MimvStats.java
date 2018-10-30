package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

public class MimvStats extends PvPStats implements Titleable {

    private LazyObject source;

    public MimvStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }


    public MimvStats(String username, boolean convertToUUID) {
        super(username, "MIMV", convertToUUID);
        source = getSource();
    }

    public String getLastUsedEmote() {
        return source.getString("lastUsedEmote");
    }

    public String getPreferredEmoteSelectorMenu() {
        return source.getString("preferredEmoteSelectorMenu");
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }
}
