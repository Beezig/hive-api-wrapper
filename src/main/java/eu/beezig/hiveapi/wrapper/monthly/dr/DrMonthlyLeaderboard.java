package eu.beezig.hiveapi.wrapper.monthly.dr;

import eu.beezig.hiveapi.wrapper.monthly.MonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DrMonthlyLeaderboard extends MonthlyLeaderboard {

    private JObject source;

    public DrMonthlyLeaderboard(JObject source) {
        super(source);
        this.source = source;
    }

    @Override
    public List<DrMonthlyProfile> getProfiles() {
        List<DrMonthlyProfile> profiles = new ArrayList<>();
        JSONObject rawData = source.getInput();
        for(Object profile : rawData.entrySet()) {
            Map.Entry<String, JSONObject> entry = (Map.Entry<String, JSONObject>) profile;
            profiles.add(new DrMonthlyProfile(new JObject(entry.getValue())));
        }
        return profiles;
    }
}
