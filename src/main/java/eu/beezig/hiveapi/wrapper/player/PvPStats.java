package eu.beezig.hiveapi.wrapper.player;

import eu.beezig.hiveapi.wrapper.utils.json.JObject;

public class PvPStats extends GameStats {

    public PvPStats(JObject source) {
        super(source);
    }

    public long getKills() {
        return getSource().getLong("kills");
    }

    public long getDeaths() {
        return getSource().getLong("deaths");
    }

}
