package eu.beezig.hiveapi.wrapper.player.games;

import eu.beezig.hiveapi.wrapper.player.GameStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.Date;
import java.util.Map;

public class GravStats extends GameStats implements Titleable {

    public GravStats(JObject source) {
        super(source);
    }

    @Override
    public long getPoints() {
        return source.getLong("points");
    }

    public Map<String, Long> getMapRecords() {
        return source.getJSONObject("maprecords");
    }

    @Override
    public Date getFirstLogin() {
        return new Date(source.getLong("firstlogin") * 1000);
    }

    @Override
    public long getGamesPlayed() {
        return source.getLong("gamesplayed");
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }
}
