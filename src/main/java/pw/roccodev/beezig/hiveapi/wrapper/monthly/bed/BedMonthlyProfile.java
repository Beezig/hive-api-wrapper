package pw.roccodev.beezig.hiveapi.wrapper.monthly.bed;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.PvPMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

public class BedMonthlyProfile extends PvPMonthlyProfile {


    private JObject source;

    public BedMonthlyProfile(JObject source) {
        super(source);
        this.source = source;
    }

    public long getVictories() {
        return source.getLong("victories");
    }

    public String getUsername() {
        return source.getString("name");
    }

    public long getGamesPlayed() {
        return source.getLong("played");
    }

    public long getBedsDestroyed() {
        return source.getLong("beds");
    }

    public long getTeamsEliminated() {
        return source.getLong("teams");
    }
}
