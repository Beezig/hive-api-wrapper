package pw.roccodev.beezig.hiveapi.wrapper.monthly.sky;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.PvPMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

public class SkyMonthlyProfile extends PvPMonthlyProfile {

    private JObject source;

    public SkyMonthlyProfile(JObject source) {
        super(source);
        this.source = source;
    }

    public long getVictories() {
        return source.getLong("victories");
    }

    public long getGamesPlayed() {
        return source.getLong("played");
    }

    public String getMostPointsChange() {
        return source.getString("most_change");
    }

}
