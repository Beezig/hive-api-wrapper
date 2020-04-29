package eu.beezig.hiveapi.wrapper.utils.download;

import eu.beezig.hiveapi.wrapper.HiveWrapper;
import eu.beezig.hiveapi.wrapper.exception.ProfileNotFoundException;
import eu.beezig.hiveapi.wrapper.utils.json.JArray;
import eu.beezig.hiveapi.wrapper.utils.json.JObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

/**
 * Asynchronous downloader
 */
public class Downloader {

    public static CompletableFuture<JObject> getJsonObject(URL url) {
        return downloadJson(url).thenApplyAsync(o -> new JObject((JSONObject) o));
    }

    public static CompletableFuture<JArray> getJsonArray(URL url) {
        return downloadJson(url).thenApplyAsync(o -> new JArray((JSONArray) o));
    }

    private static CompletableFuture<Object> downloadJson(URL url) {
        CompletableFuture<Object> future = new CompletableFuture<>();
        HiveWrapper.asyncExecute(() -> {
            HttpURLConnection conn;
            try {
                conn = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                future.completeExceptionally(e);
                return;
            }
            conn.addRequestProperty("User-Agent", HiveWrapper.USER_AGENT);
            conn.setRequestProperty("Accept", "application/json");
            try {
                if(conn.getResponseCode() == 404) {
                    future.completeExceptionally(new ProfileNotFoundException());
                    return;
                }
                try (InputStreamReader stream = new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8)) {
                    try (BufferedReader buffer = new BufferedReader(stream)) {
                        future.complete(new JSONParser().parse(buffer));
                    } catch (ParseException e) {
                        future.completeExceptionally(e);
                    }
                }
            } catch (IOException e) {
                future.completeExceptionally(e);
            }
        });
        return future;
    }
}
