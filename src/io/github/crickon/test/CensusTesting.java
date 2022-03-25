package io.github.crickon.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CensusTesting {
    public static void main(String[] args) {
        String surl = "https://census.daybreakgames.com/s:tome95309/json/get/ps2:v2/character/?character_id=5429020619200491601";
        try {
            URL url = new URL(surl);
            URLConnection request = url.openConnection();
            request.connect();
            InputStreamReader reader = new InputStreamReader(
                (InputStream) request.getContent());
            JsonElement root = JsonParser.parseReader(reader);
            JsonObject obj = root.getAsJsonObject();
            System.out.println(obj.toString());
        }
        catch (IOException e) {
        }
    }
}