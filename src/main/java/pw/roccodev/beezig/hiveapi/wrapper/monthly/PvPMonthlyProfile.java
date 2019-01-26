package pw.roccodev.beezig.hiveapi.wrapper.monthly;

import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

public class PvPMonthlyProfile extends RoccoDevMonthlyProfile {

    public PvPMonthlyProfile(JObject source) {
        super(source);
    }

    public long getKills() {
        return source.getLong("kills");
    }

    public long getDeaths() {
        return source.getLong("deaths");
    }
}
