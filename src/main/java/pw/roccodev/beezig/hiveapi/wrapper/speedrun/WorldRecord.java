package pw.roccodev.beezig.hiveapi.wrapper.speedrun;

import pw.roccodev.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.JObject;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

public class WorldRecord {

    private LazyObject wrData;
    private JObject run;

    private LazyObject holderData;

    public WorldRecord(LazyObject wrData) {
        this.wrData = wrData;
        run = wrData.getJObject("data").getJArray("runs").getJObject(0).getJObject("run");
    }

    public double getTime() {
        return run.getJObject("times").getDouble("primary_t");
    }

    public String getHolderId() {
        return run.getJArray("players").getJObject(0).getString("id");
    }

    public String getHolderName() {
        if(holderData == null) {
            holderData = new LazyObject(null, new UrlBuilder().speedrun().user(getHolderId()).build());
        }
        return holderData.getJObject("data").getJObject("names").getString("international");
    }


}
