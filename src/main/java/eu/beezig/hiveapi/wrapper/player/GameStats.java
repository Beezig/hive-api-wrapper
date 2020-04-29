package eu.beezig.hiveapi.wrapper.player;

import eu.beezig.hiveapi.wrapper.utils.json.JObject;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class GameStats {

    protected JObject source;

    public GameStats(JObject source) {
        this.source = source;
    }

    public String getUUID() {
        return source.getString("UUID");
    }

    public long getPoints() {
        return source.getLong("total_points");
    }

    public long getVictories() {
        return source.getLong("victories");
    }

    public long getGamesPlayed() {
        return source.getLong("games_played");
    }

    public List<Achievement> getAchievements() {

        JSONObject rawAchievements = source.getJSONObject("achievements");
        List<Achievement> achievements = new ArrayList<>();
        HivePlayer.parseAchievements(rawAchievements, achievements);

        return achievements;
    }

    public List<Achievement> getUnlockedAchievements() {
        return getAchievements().stream().filter(Achievement::isUnlocked).collect(Collectors.toList());
    }

    public Date getFirstLogin() {
        return new Date(source.getLong("firstLogin") * 1000);
    }

    public Date getLastLogin() {
        return new Date(source.getLong("lastlogin") * 1000);
    }

    public Date getCachedAt() {
        return new Date(source.getLong("cached") * 1000);
    }

    public JObject getSource() {
        return source;
    }

    public CompletableFuture<HivePlayer> getPlayer() {
        return Profiles.global(source.getString("UUID"));
    }

}
