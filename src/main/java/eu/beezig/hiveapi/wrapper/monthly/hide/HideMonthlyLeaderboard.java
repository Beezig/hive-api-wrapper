package eu.beezig.hiveapi.wrapper.monthly.hide;

import eu.beezig.hiveapi.wrapper.monthly.MonthlyLeaderboard;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HideMonthlyLeaderboard extends MonthlyLeaderboard {

    private JObject source;

    public HideMonthlyLeaderboard(JObject source) {
        super(source);
        this.source = source;
    }

    @Override
    public List<HideMonthlyProfile> getProfiles() {
        List<HideMonthlyProfile> profiles = new ArrayList<>();
        JSONObject rawData = source.getInput();
        for(Object profile : rawData.entrySet()) {
            Map.Entry<String, JSONObject> entry = (Map.Entry<String, JSONObject>) profile;
            profiles.add(new HideMonthlyProfile(new JObject(entry.getValue())));
        }
        return profiles;
    }
}
