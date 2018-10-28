package pw.roccodev.beezig.hiveapi.wrapper.monthly.maxthat.timv;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.maxthat.MaxthatMonthlyLeaderboard;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.maxthat.MaxthatMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.List;

public class TimvMonthlyLeaderboard extends MaxthatMonthlyLeaderboard {

    public TimvMonthlyLeaderboard(JObject source) {
        super(source);
    }

    public TimvMonthlyLeaderboard(List<MaxthatMonthlyProfile> profiles) {
        super(profiles);
    }

    @Override
    public List<TimvMonthlyProfile> getProfiles() {
        return (List<TimvMonthlyProfile>) super.getProfiles();
    }
}
