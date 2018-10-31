package pw.roccodev.beezig.hiveapi.wrapper.game.leaderboard;

import org.json.simple.JSONObject;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.List;
import java.util.stream.Collectors;

public class GameLeaderboard {

    private LazyObject source;

    public GameLeaderboard(LazyObject source) {
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
