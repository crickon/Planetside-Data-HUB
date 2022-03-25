package io.github.crickon.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.github.crickon.struct.Census;

public class Planetside {
	public static Census getPlayerCensusFromID(String id) {
		try {
			String surl = "https://census.daybreakgames.com/s:tome95309/json/get/ps2:v2/character/?character_id=" + id;
			URL url = new URL(surl);
			URLConnection request = url.openConnection();
			request.connect();
			InputStreamReader reader = new InputStreamReader((InputStream) request.getContent());
			JsonElement root = JsonParser.parseReader(reader);
			JsonObject obj = root.getAsJsonObject();
			return new Census().parse(obj);
		} catch (IOException e) {
			return null;
		}
	}

	public static Census getPlayerCensusFromName(String name) {
		try {
			String surl = "https://census.daybreakgames.com/s:tome95309/json/get/ps2:v2/character/?name.first_lower="
					+ name.toLowerCase();
			URL url = new URL(surl);
			URLConnection request = url.openConnection();
			request.connect();
			InputStreamReader reader = new InputStreamReader((InputStream) request.getContent());
			JsonElement root = JsonParser.parseReader(reader);
			JsonObject obj = root.getAsJsonObject();
			return new Census().parse(obj);
		} catch (IOException e) {
			return null;
		}
	}
}