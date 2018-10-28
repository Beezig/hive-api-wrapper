package pw.roccodev.beezig.hiveapi.wrapper.monthly.maxthat;

import org.json.simple.JSONObject;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.MonthlyLeaderboard;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.maxthat.dr.DrMonthlyLeaderboard;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.maxthat.dr.DrMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.maxthat.timv.TimvMonthlyLeaderboard;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.maxthat.timv.TimvMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JArray;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MaxthatMonthlyLeaderboard extends MonthlyLeaderboard {

    private JObject source;
    private List<MaxthatMonthlyProfile> profiles;

    public MaxthatMonthlyLeaderboard(JObject source) {
        super(source);
        this.source = source;
    }

    public MaxthatMonthlyLeaderboard(List<MaxthatMonthlyProfile> profiles) {
        super(null);
        this.profiles = profiles;
    }

    @Override
    public List<? extends MaxthatMonthlyProfile> getProfiles() {
        if(profiles != null) return profiles;
        if(source instanceof LazyObject) ((LazyObject)source).fetch();
        profiles = new ArrayList<>();

        JArray rawLeaderboard = source.getJArray("leaderboard");
        for(Object o : rawLeaderboard.getInput()) {
            JSONObject profile = (JSONObject) o;
            if(this instanceof TimvMonthlyLeaderboard)
                profiles.add(new TimvMonthlyProfile(new JObject(profile), rawLeaderboard.getInput().indexOf(o)));
            else profiles.add(new DrMonthlyProfile(new JObject(profile), rawLeaderboard.getInput().indexOf(o)));
        }

        return profiles;
    }

    public MaxthatMonthlyLeaderboard filter(Predicate<MaxthatMonthlyProfile> condition) {
        if(this instanceof TimvMonthlyLeaderboard)
        return new TimvMonthlyLeaderboard(getProfiles().stream().filter(condition).collect(Collectors.toList()));
        else return new DrMonthlyLeaderboard(getProfiles().stream().filter(condition).collect(Collectors.toList()));
    }
}
