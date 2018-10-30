package pw.roccodev.beezig.hiveapi.wrapper.player.games;

import pw.roccodev.beezig.hiveapi.wrapper.player.GameStats;
import pw.roccodev.beezig.hiveapi.wrapper.player.Titleable;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.Map;

public class LabStats extends GameStats implements Titleable {

    private LazyObject source;

    public LabStats(String usernameOrUUID) {
        this(usernameOrUUID, false);
    }

    public LabStats(String username, boolean convertToUUID) {
        super(username, "LAB", convertToUUID);
        source = getSource();
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
