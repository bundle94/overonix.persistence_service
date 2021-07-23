package com.overonix.persistence.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.overonix.persistence.model.Player;
import com.overonix.persistence.repository.PlayerRepository;
import com.overonix.persistence.util.PlayerDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PersistenceServiceImpl implements PersistenceService{

    private PlayerRepository playerRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceServiceImpl.class);

    @Autowired
    public PersistenceServiceImpl (PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    @KafkaListener(topics = "overonix-distributed", groupId = "group-id")
    public void consume(String message) throws JsonProcessingException {
        Player player = deserialize(message);
        playerRepository.save(player);
    }

    private Player deserialize(String request) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Player.class, new PlayerDeserializer());
        mapper.registerModule(module);
        Player player = mapper.readValue(request, Player.class);
        return player;
    }
}
