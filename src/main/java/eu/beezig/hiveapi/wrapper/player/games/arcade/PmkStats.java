package eu.beezig.hiveapi.wrapper.player.games.arcade;

import eu.beezig.hiveapi.wrapper.player.PvPStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

public class PmkStats extends PvPStats implements Titleable {

    public PmkStats(JObject source) {
        super(source);
    }

    public long getInfections() {
        return source.getLong("infections");
    }

    @Override
    public long getDeaths() {
        return getInfections();
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }
}
