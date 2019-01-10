package pw.roccodev.beezig.hiveapi.wrapper.monthly.dr;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.MonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

public class DrMonthlyProfile extends MonthlyProfile {

    private JObject source;

    public DrMonthlyProfile(JObject source) {
        super(source);
        this.source = source;
    }

    @Override
    public long getPoints() {
        return source.getLong("points");
    }

    public String getUsername() {
        return source.getString("username");
    }

    @Override
    public long getPlace() {
        return source.getLong("place");
    }

    public long getVictories() {
        return source.getLong("victories");
    }

    public long getGamesPlayed() {
        return source.getLong("played");
    }

    public long getKills() {
        return source.getLong("kills");
    }

    public long getDeaths() {
        return source.getLong("deaths");
    }

}
