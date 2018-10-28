package pw.roccodev.beezig.hiveapi.wrapper.monthly.bed;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.MonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

public class BedMonthlyProfile extends MonthlyProfile {


    private JObject source;

    public BedMonthlyProfile(JObject source) {
        super(source);
        this.source = source;
    }

    @Override
    public long getPoints() {
        return source.getLong("points");
    }

    @Override
    public long getPlace() {
        return source.getLong("place");
    }

    public long getVictories() {
        return source.getLong("victories");
    }

    public String getUsername() {
        return source.getString("name");
    }

    public long getKills() {
        return source.getLong("kills");
    }

    public long getDeaths() {
        return source.getLong("deaths");
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
