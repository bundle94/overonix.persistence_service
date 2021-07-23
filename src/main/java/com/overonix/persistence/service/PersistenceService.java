package com.overonix.persistence.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface PersistenceService {
    void consume(String message) throws JsonProcessingException;
}
