package eu.beezig.hiveapi.wrapper.monthly.sp;

import eu.beezig.hiveapi.wrapper.monthly.MonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SpMonthlyLeaderboard extends MonthlyLeaderboard {

    private JObject source;

    public SpMonthlyLeaderboard(JObject source) {
        super(source);
        this.source = source;
    }

    @Override
    public List<SpMonthlyProfile> getProfiles() {
        List<SpMonthlyProfile> profiles = new ArrayList<>();
        JSONObject rawData = source.getInput();
        for(Object profile : rawData.entrySet()) {
            Map.Entry<String, JSONObject> entry = (Map.Entry<String, JSONObject>) profile;
            profiles.add(new SpMonthlyProfile(new JObject(entry.getValue())));
        }
        return profiles;
    }
}
