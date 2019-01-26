package pw.roccodev.beezig.hiveapi.wrapper.monthly.bp;

import org.json.simple.JSONObject;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.MonthlyLeaderboard;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BpMonthlyLeaderboard extends MonthlyLeaderboard {

    private JObject source;

    public BpMonthlyLeaderboard(JObject source) {
        super(source);
        this.source = source;
    }

    @Override
    public List<BpMonthlyProfile> getProfiles() {
        if(source instanceof LazyObject) ((LazyObject)source).fetch();

        List<BpMonthlyProfile> profiles = new ArrayList<>();

        JSONObject rawData = source.getInput();
        for(Object profile : rawData.entrySet()) {
            Map.Entry<String, JSONObject> entry = (Map.Entry<String, JSONObject>) profile;

            profiles.add(new BpMonthlyProfile(new JObject(entry.getValue())));
        }

        return profiles;
    }
}
