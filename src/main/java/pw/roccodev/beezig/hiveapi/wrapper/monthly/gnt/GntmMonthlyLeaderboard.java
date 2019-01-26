package pw.roccodev.beezig.hiveapi.wrapper.monthly.gnt;

import org.json.simple.JSONObject;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GntmMonthlyLeaderboard extends GntMonthlyLeaderboard {

    private JObject source;

    public GntmMonthlyLeaderboard(JObject source) {
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

            profiles.add(new GntmMonthlyProfile(new JObject(entry.getValue())));
        }

        return profiles;
    }
}
