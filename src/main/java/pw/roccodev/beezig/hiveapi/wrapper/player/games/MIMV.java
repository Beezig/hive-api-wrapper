package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

public class MIMV extends PvPStats {

    private LazyObject source;

    public MIMV(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }


    public MIMV(String username, boolean convertToUUID) {
        super(username, "MIMV", convertToUUID);
        source = getSource();
    }

    public String getLastUsedEmote() {
        return source.getString("lastUsedEmote");
    }

    public String getPreferredEmoteSelectorMenu() {
        return source.getString("preferredEmoteSelectorMenu");
    }
}
