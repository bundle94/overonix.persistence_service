package com.overonix.persistence.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.overonix.persistence.model.Player;

import java.io.IOException;

public class PlayerDeserializer extends StdDeserializer<Player> {

    public PlayerDeserializer() {
        this(null);
    }

    public PlayerDeserializer(Class<?> c) {
        super(c);
    }

    @Override
    public Player deserialize(JsonParser jsonParser, DeserializationContext Context) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String uuid = node.get("uuid").asText();
        String email = node.get("email").asText();
        String password = node.get("password").asText();

        return new Player(uuid, email, password);
    }


}
