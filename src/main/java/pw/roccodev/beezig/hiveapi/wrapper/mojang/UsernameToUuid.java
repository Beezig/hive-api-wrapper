package pw.roccodev.beezig.hiveapi.wrapper.mojang;

import pw.roccodev.beezig.hiveapi.wrapper.utils.download.UrlBuilder;
import pw.roccodev.beezig.hiveapi.wrapper.utils.json.LazyObject;

public class UsernameToUuid {

    public static String getUUID(String username) {
        LazyObject responseFromMojang = new LazyObject(null, new UrlBuilder().mojang(username).build());
        return responseFromMojang.getString("id");
    }

}
