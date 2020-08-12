package eu.beezig.hiveapi.wrapper.monthly.sp;

import eu.beezig.hiveapi.wrapper.monthly.RoccoDevMonthlyProfile;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

public class SpMonthlyProfile extends RoccoDevMonthlyProfile {
    private JObject source;

    public SpMonthlyProfile(JObject source) {
        super(source);
        this.source = source;
    }

    public long getVictories() {
        return source.getLong("victories");
    }

    public long getGamesPlayed() {
        return source.getLong("played");
    }

    public long getEggsThrown() {
        return source.getLong("eggs");
    }

    public long getDeaths() {
        return source.getLong("deaths");
    }

    public long getBlocksDestroyed() {
        return source.getLong("blocks");
    }
}
