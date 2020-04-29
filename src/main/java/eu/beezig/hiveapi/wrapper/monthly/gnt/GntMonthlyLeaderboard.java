package eu.beezig.hiveapi.wrapper.monthly.gnt;

import eu.beezig.hiveapi.wrapper.monthly.MonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GntMonthlyLeaderboard extends MonthlyLeaderboard {

    private JObject source;

    public GntMonthlyLeaderboard(JObject source) {
        super(source);
        this.source = source;
    }

    @Override
    public List<GntMonthlyProfile> getProfiles() {
        List<GntMonthlyProfile> profiles = new ArrayList<>();
        JSONObject rawData = source.getInput();
        for(Object profile : rawData.entrySet()) {
            Map.Entry<String, JSONObject> entry = (Map.Entry<String, JSONObject>) profile;
            profiles.add(new GntMonthlyProfile(new JObject(entry.getValue())));
        }
        return profiles;
    }
}
