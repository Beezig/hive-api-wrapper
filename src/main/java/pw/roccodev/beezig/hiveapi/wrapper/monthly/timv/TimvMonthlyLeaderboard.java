package pw.roccodev.beezig.hiveapi.wrapper.monthly.timv;

import org.json.simple.JSONObject;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.MonthlyLeaderboard;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

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
        if(source instanceof LazyObject) ((LazyObject)source).fetch();

        List<TimvMonthlyProfile> profiles = new ArrayList<>();

        JSONObject rawData = source.getInput();
        for(Object profile : rawData.entrySet()) {
            Map.Entry<String, JSONObject> entry = (Map.Entry<String, JSONObject>) profile;

            profiles.add(new TimvMonthlyProfile(new JObject(entry.getValue())));
        }

        return profiles;
    }
}
