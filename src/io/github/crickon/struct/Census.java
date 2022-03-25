package io.github.crickon.struct;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Census {
	private String character_id;
	private String first_name;
	private int faction_id;

	public Census parse(JsonObject root) {
		try {
			JsonArray list = root.get("character_list").getAsJsonArray();
			JsonObject character = list.get(0).getAsJsonObject();

			character_id = character.get("character_id").getAsString();
			first_name = character.get("name").getAsJsonObject().get("first").getAsString();
			faction_id = character.get("faction_id").getAsInt();
			return this;
		} catch (Exception e) {
			return null;
		}
	}

	public String character_id() {
		return this.character_id;
	}

	public String first_name() {
		return this.first_name;
	}

	public int faction_id() {
		return this.faction_id;
	}

	public String toString() {
		return "Census record for " + character_id;
	}
}