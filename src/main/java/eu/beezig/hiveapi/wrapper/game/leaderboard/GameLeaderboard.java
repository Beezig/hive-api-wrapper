package eu.beezig.hiveapi.wrapper.game.leaderboard;

import eu.beezig.hiveapi.wrapper.utils.json.JObject;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.stream.Collectors;

public class GameLeaderboard {

    private JObject source;

    public GameLeaderboard(JObject source) {
        this.source = source;
    }

    public long getStart() {
        return source.getLong("start");
    }

    public long getEnd() {
        return source.getLong("end");
    }

    public List<LeaderboardPlace> getPlayers() {
        return (List<LeaderboardPlace>) source.getJSONArray("leaderboard")
                .stream().map((place) -> new LeaderboardPlace((JSONObject) place)).collect(Collectors.toList());
    }

}
