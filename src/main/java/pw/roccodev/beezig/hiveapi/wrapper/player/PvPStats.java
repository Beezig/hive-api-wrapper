package pw.roccodev.beezig.hiveapi.wrapper.player;

public class PvPStats extends GameStats {

    public PvPStats(String usernameOrUUID, String shortcode) {
        this(usernameOrUUID, shortcode, false);
    }

    public PvPStats(String username, String shortcode, boolean convertToUUID) {
        super(username, shortcode, convertToUUID);
    }

    public long getKills() {
        return getSource().getLong("kills");
    }

    public long getDeaths() {
        return getSource().getLong("deaths");
    }


}
