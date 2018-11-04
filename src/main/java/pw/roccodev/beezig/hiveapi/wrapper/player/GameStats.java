package pw.roccodev.beezig.hiveapi.wrapper.player;

import org.json.simple.JSONObject;
import pw.roccodev.beezig.hiveapi.wrapper.game.Game;
import pw.roccodev.beezig.hiveapi.wrapper.mojang.UsernameToUuid;
import pw.roccodev.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class GameStats {

    private LazyObject source;
    private String usernameOrUUID;
    private String shortcode;

    public GameStats(String username, String shortcode, boolean convertToUUID) {
        this.shortcode = shortcode;

        if(convertToUUID &&
                username.length() != 32) // Short-circuit for inputs that are already UUIDs
            usernameOrUUID = UsernameToUuid.getUUID(username);
        else usernameOrUUID = username;

        source = new LazyObject(null, new UrlBuilder().hive().player(usernameOrUUID, shortcode).build());
    }

    public GameStats(String usernameOrUUID, String shortcode) {
       this(usernameOrUUID, shortcode, false);
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

    public LazyObject getSource() {
        return source;
    }

    public HivePlayer getPlayer() {
        return new HivePlayer(usernameOrUUID);
    }

    public Game getGameMode() {
        return new Game(shortcode);
    }


}
