package pw.roccodev.beezig.hiveapi.wrapper.monthly;

import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.List;

public abstract class MonthlyLeaderboard {

    private JObject source;

    public MonthlyLeaderboard(JObject source) {
        this.source = source;

    }

    public abstract List<? extends MonthlyProfile> getProfiles();

}
