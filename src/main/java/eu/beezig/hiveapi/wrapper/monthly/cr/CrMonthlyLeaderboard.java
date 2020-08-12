package eu.beezig.hiveapi.wrapper.monthly.cr;

import eu.beezig.hiveapi.wrapper.monthly.MonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CrMonthlyLeaderboard extends MonthlyLeaderboard {

    private JObject source;

    public CrMonthlyLeaderboard(JObject source) {
        super(source);
        this.source = source;
    }

    @Override
    public List<CrMonthlyProfile> getProfiles() {
        List<CrMonthlyProfile> profiles = new ArrayList<>();
        JSONObject rawData = source.getInput();
        for(Object profile : rawData.entrySet()) {
            Map.Entry<String, JSONObject> entry = (Map.Entry<String, JSONObject>) profile;
            profiles.add(new CrMonthlyProfile(new JObject(entry.getValue())));
        }
        return profiles;
    }
}
