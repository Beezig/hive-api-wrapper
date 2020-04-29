package eu.beezig.hiveapi.wrapper.player.games;

import eu.beezig.hiveapi.wrapper.player.GameStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Map;

public class LabStats extends GameStats implements Titleable {

    public LabStats(JObject source) {
        super(source);
    }

    @Override
    public long getGamesPlayed() {
        return source.getLong("gamesplayed");
    }

    public long getAtoms() {
        return getPoints();
    }

    public Map<String, Long> getGameVictories() {
        return source.getJSONObject("game_victories");
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }

}
