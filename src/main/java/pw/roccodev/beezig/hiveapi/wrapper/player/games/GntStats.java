package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.player.PvPStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Date;

public class GntStats extends PvPStats implements Titleable {

    private LazyObject source;

    public GntStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public GntStats(String username, boolean convertToUUID) {
        this(username, "GNT", convertToUUID);
    }

    GntStats(String username, String shortcode, boolean convertToUUID) {
        super(username, shortcode, convertToUUID);
        source = getSource();
    }

    @Override
    public Date getFirstLogin() {
        return new Date(source.getLong("firstlogin") * 1000);
    }

    public long getGoldEarned() {
        return source.getLong("gold_earned");
    }

    public long getBeastsSlain() {
        return source.getLong("beasts_slain");
    }

    public long getShutdowns() {
        return source.getLong("shutdowns");
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }
}
