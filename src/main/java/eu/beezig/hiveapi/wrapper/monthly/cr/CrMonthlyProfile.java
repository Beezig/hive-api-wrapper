package eu.beezig.hiveapi.wrapper.monthly.cr;

import eu.beezig.hiveapi.wrapper.monthly.RoccoDevMonthlyProfile;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

public class CrMonthlyProfile extends RoccoDevMonthlyProfile {
    private JObject source;

    public CrMonthlyProfile(JObject source) {
        super(source);
        this.source = source;
    }

    public long getVictories() {
        return source.getLong("victories");
    }

    public long getKills() {
        return source.getLong("kills");
    }

    public long getDeaths() {
        return source.getLong("deaths");
    }
}
