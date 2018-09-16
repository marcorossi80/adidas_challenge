package com.adidas.challenge.cityconnectionmanager.exception;

public class EntityNotFoundException extends RuntimeException {

    private final static String ERROR_MESSAGE = "The %s with id %s has not been found";

    public EntityNotFoundException(String entity, Object id) {
        super(String.format(ERROR_MESSAGE, entity, id));
    }

}

