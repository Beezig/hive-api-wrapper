package eu.beezig.hiveapi.wrapper.monthly.gnt;

import eu.beezig.hiveapi.wrapper.monthly.PvPMonthlyProfile;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

public class GntMonthlyProfile extends PvPMonthlyProfile {

    private JObject source;

    public GntMonthlyProfile(JObject source) {
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
