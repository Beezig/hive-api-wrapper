package eu.beezig.hiveapi.wrapper.monthly.bed;

import eu.beezig.hiveapi.wrapper.monthly.MonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BedMonthlyLeaderboard extends MonthlyLeaderboard {

    private JObject source;

    public BedMonthlyLeaderboard(JObject source) {
        super(source);
        this.source = source;
    }

    @Override
    public List<BedMonthlyProfile> getProfiles() {
        List<BedMonthlyProfile> profiles = new ArrayList<>();
        JSONObject rawData = source.getInput();
        for(Object profile : rawData.entrySet()) {
            Map.Entry<String, JSONObject> entry = (Map.Entry<String, JSONObject>) profile;
            profiles.add(new BedMonthlyProfile(new JObject(entry.getValue())));
        }
        return profiles;
    }
}
