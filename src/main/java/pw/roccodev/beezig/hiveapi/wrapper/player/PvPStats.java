package pw.roccodev.beezig.hiveapi.wrapper.player;

public class PvPStats extends GameStats {

    public PvPStats(String usernameOrUUID, String shortcode) {
        super(usernameOrUUID, shortcode);
    }

    public long getKills() {
        return getSource().getLong("kills");
    }

    public long getDeaths() {
        return getSource().getLong("deaths");
    }


}
