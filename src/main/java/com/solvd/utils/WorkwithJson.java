package com.solvd.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.pojo.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Paths;


public class WorkwithJson {

    private static final Logger LOGGER = LogManager.getLogger(WorkwithJson.class);

    public Transaction JsonReader(String pathtoFile) {

        Transaction transaction = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            transaction = objectMapper.readValue(Paths.get(pathtoFile).toFile(), Transaction.class);
            LOGGER.info("file already read");
        } catch (JsonProcessingException e) {
           LOGGER.error(e);
        } catch (IOException e) {
            LOGGER.error(e);
        }

        return transaction;
    }

    public Transaction convertJsontoPOJO (String jsonStr) {

        Transaction transaction = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            transaction = mapper.readValue(jsonStr, Transaction.class);
            LOGGER.info("json converted to pojo");
        } catch (JsonProcessingException e) {
            LOGGER.error(e);
        }
    return transaction;
    }

}

