package pw.roccodev.beezig.hiveapi.wrapper.player.rank;

import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

public class PlayerRank {

    private JObject source;

    public PlayerRank(JObject source) {
        this.source = source;
    }

    public String getHumanName() {
        return source.getString("human");
    }

    public String getEnumName() {
        return source.getString("enum");
    }

    public int getIndex() {
        return source.getInt("index");
    }

}
