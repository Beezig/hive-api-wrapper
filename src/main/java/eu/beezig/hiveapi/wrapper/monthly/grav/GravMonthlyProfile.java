package eu.beezig.hiveapi.wrapper.monthly.grav;

import eu.beezig.hiveapi.wrapper.monthly.RoccoDevMonthlyProfile;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

public class GravMonthlyProfile extends RoccoDevMonthlyProfile {
    private JObject source;

    public GravMonthlyProfile(JObject source) {
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
