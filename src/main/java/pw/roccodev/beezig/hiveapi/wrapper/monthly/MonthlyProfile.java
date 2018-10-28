package pw.roccodev.beezig.hiveapi.wrapper.monthly;

import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;

public abstract class MonthlyProfile {

    JObject source;

    public MonthlyProfile(JObject source) {
        this.source = source;
    }

    public abstract long getPoints();
    public abstract long getPlace();

}
