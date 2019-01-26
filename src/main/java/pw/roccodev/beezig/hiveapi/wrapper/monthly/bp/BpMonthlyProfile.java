package pw.roccodev.beezig.hiveapi.wrapper.monthly.bp;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.RoccoDevMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

public class BpMonthlyProfile extends RoccoDevMonthlyProfile {

    private JObject source;

    public BpMonthlyProfile(JObject source) {
        super(source);
        this.source = source;
    }

    public long getVictories() {
        return source.getLong("victories");
    }

    public long getGamesPlayed() {
        return source.getLong("played");
    }

    public long getPlacings() {
        return source.getLong("placings");
    }

    public long getEliminations() {
        return source.getLong("eliminations");
    }

}
