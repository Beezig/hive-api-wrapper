package eu.beezig.hiveapi.wrapper.monthly.bd;

import eu.beezig.hiveapi.wrapper.monthly.RoccoDevMonthlyProfile;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

public class BdMonthlyProfile extends RoccoDevMonthlyProfile {
    private JObject source;

    public BdMonthlyProfile(JObject source) {
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

    public long getGamesPlayed() {
        return source.getLong("played");
    }

    public long getEnergyCollected() {
        return source.getLong("energy");
    }
}
