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

    public long getHiderKills() {
        return source.getLong("hider_kills");
    }

    public long getSeekerKills() {
        return source.getLong("seeker_kills");
    }

}
