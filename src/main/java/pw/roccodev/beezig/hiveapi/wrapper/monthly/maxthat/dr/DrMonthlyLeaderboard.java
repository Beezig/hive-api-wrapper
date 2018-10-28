package pw.roccodev.beezig.hiveapi.wrapper.monthly.maxthat.dr;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.maxthat.MaxthatMonthlyLeaderboard;
import pw.roccodev.beezig.hiveapi.wrapper.monthly.maxthat.MaxthatMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

import java.util.List;

public class DrMonthlyLeaderboard extends MaxthatMonthlyLeaderboard {

    public DrMonthlyLeaderboard(JObject source) {
        super(source);
    }

    public DrMonthlyLeaderboard(List<MaxthatMonthlyProfile> profiles) {
        super(profiles);
    }

    @Override
    public List<DrMonthlyProfile> getProfiles() {
        return (List<DrMonthlyProfile>) super.getProfiles();
    }
}
