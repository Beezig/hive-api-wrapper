package pw.roccodev.beezig.hiveapi.wrapper.monthly.maxthat.dr;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.maxthat.MaxthatMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

public class DrMonthlyProfile extends MaxthatMonthlyProfile {

    private JObject source;

    public DrMonthlyProfile(JObject source, int key) {
        super(source, key);
        this.source = source;
    }

    public long getVictories() {
        return source.getLong("wins");
    }

    public long getGamesPlayed() {
        return source.getLong("games");
    }

    public long getKills() {
        return source.getLong("kills");
    }

    public long getDeaths() {
        return source.getLong("deaths");
    }

}
