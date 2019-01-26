package pw.roccodev.beezig.hiveapi.wrapper.monthly.gnt;

import org.json.simple.JSONObject;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.MonthlyLeaderboard;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

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
        if(source instanceof LazyObject) ((LazyObject)source).fetch();

        List<GntMonthlyProfile> profiles = new ArrayList<>();

        JSONObject rawData = source.getInput();
        for(Object profile : rawData.entrySet()) {
            Map.Entry<String, JSONObject> entry = (Map.Entry<String, JSONObject>) profile;

            profiles.add(new GntMonthlyProfile(new JObject(entry.getValue())));
        }

        return profiles;
    }
}
