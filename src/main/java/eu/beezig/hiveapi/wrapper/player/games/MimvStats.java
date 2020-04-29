package eu.beezig.hiveapi.wrapper.player.games;

import eu.beezig.hiveapi.wrapper.player.PvPStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

public class MimvStats extends PvPStats implements Titleable {

    public MimvStats(JObject source) {
        super(source);
    }

    public String getLastUsedEmote() {
        return source.getString("lastUsedEmote");
    }

    public String getPreferredEmoteSelectorMenu() {
        return source.getString("preferredEmoteSelectorMenu");
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }
}
