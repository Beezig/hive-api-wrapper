package eu.beezig.hiveapi.wrapper.player.games.arcade;

import eu.beezig.hiveapi.wrapper.player.PvPStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

public class SurvStats extends PvPStats implements Titleable {

    public SurvStats(JObject source) {
        super(source);
    }

    public long getGeneratorsPowered() {
        return source.getLong("generators_powered");
    }

    public long getLootedCrates() {
        return source.getLong("looted_crates");
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }
}
