package eu.beezig.hiveapi.wrapper.monthly.dr;

import eu.beezig.hiveapi.wrapper.monthly.PvPMonthlyProfile;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

public class DrMonthlyProfile extends PvPMonthlyProfile {

    private JObject source;

    public DrMonthlyProfile(JObject source) {
        super(source);
        this.source = source;
    }

    public long getVictories() {
        return source.getLong("victories");
    }

    public long getGamesPlayed() {
        return source.getLong("played");
    }

}
