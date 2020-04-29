package eu.beezig.hiveapi.wrapper.player.games.arcade;

import eu.beezig.hiveapi.wrapper.player.PvPStats;
import eu.beezig.hiveapi.wrapper.player.Titleable;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SplStats extends PvPStats implements Titleable {

    public SplStats(JObject source) {
        super(source);
    }

    public long getBlocksPainted() {
        return source.getLong("blockspainted");
    }

    public long getUltimatesEarned() {
        return source.getLong("ultimates_earned");
    }

    public HashMap<String, SploopCharacterStats> getCharacterStats() {

        HashMap<String, SploopCharacterStats> stats = new HashMap<>();

        JSONObject rawStats = source.getJSONObject("character_stats");
        for(Object o : rawStats.entrySet()) {
            if(!(o instanceof Map.Entry)) continue;
            Map.Entry<String, JSONObject> entry = (Map.Entry<String, JSONObject>) o;
            stats.put(entry.getKey(), new SploopCharacterStats(new JObject(entry.getValue())));
        }

        return stats;
    }

    public SploopCharacterStats getStatsByCharacter(String raw) {
        return getCharacterStats().get(raw);
    }

    public SploopCharacterStats getStatsByCharacter(Character character) {
        return getStatsByCharacter(character.getApiKey());
    }

    @Override
    public String getTitle() {
        return source.getString("title");
    }


    public class SploopCharacterStats {

        private JObject source;

        SploopCharacterStats(JObject source) {
            this.source = source;
        }

        public long getBlocksPainted() {
            return source.getLong("blocks_painted");
        }

        public long getKills() {
            return source.getLong("kills");
        }

        public long getDeaths() {
            return source.getLong("deaths");
        }

        public long getGamesPlayed() {
            return source.getLong("games_played");
        }

        public long getUltimateKills() {
            return source.getLong("ultimate_kills");
        }


    }

    public enum Character {

        TORSTEIN("TorsteinCharacter"),
        RAVEN("RavenCharacter"),
        BOOSTER("BoosterCharacter"),
        OINKY("OinkyCharacter");

        private String apiKey;

        Character(String apiKey) {
            this.apiKey = apiKey;
        }

        public String getApiKey() {
            return apiKey;
        }

    }

}
