package eu.beezig.hiveapi.wrapper.monthly.timv;

import eu.beezig.hiveapi.wrapper.monthly.MonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TimvMonthlyLeaderboard extends MonthlyLeaderboard {

    private JObject source;

    public TimvMonthlyLeaderboard(JObject source) {
        super(source);
        this.source = source;
    }

    @Override
    public List<TimvMonthlyProfile> getProfiles() {
        List<TimvMonthlyProfile> profiles = new ArrayList<>();
        JSONObject rawData = source.getInput();
        for(Object profile : rawData.entrySet()) {
            Map.Entry<String, JSONObject> entry = (Map.Entry<String, JSONObject>) profile;

            profiles.add(new TimvMonthlyProfile(new JObject(entry.getValue())));
        }
        return profiles;
    }
}
