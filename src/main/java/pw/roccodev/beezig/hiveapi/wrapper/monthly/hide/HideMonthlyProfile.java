package pw.roccodev.beezig.hiveapi.wrapper.monthly.hide;

import pw.roccodev.beezig.hiveapi.wrapper.monthly.RoccoDevMonthlyProfile;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

public class HideMonthlyProfile extends RoccoDevMonthlyProfile {

    private JObject source;

    public HideMonthlyProfile(JObject source) {
        super(source);
        this.source = source;
    }

    public long getVictories() {
        return source.getLong("victories");
    }

    public long getGamesPlayed() {
        return source.getLong("played");
    }

    public String getHiderKills() {
        return source.getString("hider_kills");
    }

    public String getSeekerKills() {
        return source.getString("seeker_kills");
    }

}
