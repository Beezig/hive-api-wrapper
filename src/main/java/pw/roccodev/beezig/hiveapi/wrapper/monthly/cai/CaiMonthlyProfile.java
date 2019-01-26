package pw.roccodev.beezig.hiveapi.wrapper.monthly.cai;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.RoccoDevMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

public class CaiMonthlyProfile extends RoccoDevMonthlyProfile {

    private JObject source;

    public CaiMonthlyProfile(JObject source) {
        super(source);
        this.source = source;
    }

    public long getVictories() {
        return source.getLong("victories");
    }

    public long getGamesPlayed() {
        return source.getLong("played");
    }

    public long getCaptures() {
        return source.getLong("captures");
    }

    public long getCaught() {
        return source.getLong("caught");
    }

}
