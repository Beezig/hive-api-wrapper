package pw.roccodev.beezig.hiveapi.wrapper.game.leaderboard;

import org.json.simple.JSONObject;

public class LeaderboardPlace extends JSONObject {

    public LeaderboardPlace(JSONObject in) {
        putAll(in);
    }

    public long getPlace() {
        return (long) get("index");
    }

    public long getHumanPlace() {
        return getPlace() + 1;
    }

}
