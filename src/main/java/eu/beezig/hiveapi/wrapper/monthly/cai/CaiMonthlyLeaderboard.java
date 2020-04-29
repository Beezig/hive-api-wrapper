package eu.beezig.hiveapi.wrapper.monthly.cai;

import eu.beezig.hiveapi.wrapper.monthly.MonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CaiMonthlyLeaderboard extends MonthlyLeaderboard {

    private JObject source;

    public CaiMonthlyLeaderboard(JObject source) {
        super(source);
        this.source = source;
    }

    @Override
    public List<CaiMonthlyProfile> getProfiles() {
        List<CaiMonthlyProfile> profiles = new ArrayList<>();
        JSONObject rawData = source.getInput();
        for(Object profile : rawData.entrySet()) {
            Map.Entry<String, JSONObject> entry = (Map.Entry<String, JSONObject>) profile;
            profiles.add(new CaiMonthlyProfile(new JObject(entry.getValue())));
        }
        return profiles;
    }
}
