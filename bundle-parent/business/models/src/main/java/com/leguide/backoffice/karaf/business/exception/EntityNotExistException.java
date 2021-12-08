package com.leguide.backoffice.karaf.business.exception;

public class EntityNotExistException extends Exception {

    private static final long serialVersionUID = -3232119260342282209L;

    public EntityNotExistException() {
        super("Entity does not exist !");
    }

    public EntityNotExistException(EntityType entityType, Long entityId) {
        super("Entity of type " + entityType.getName() + " and id " + entityId + " does not exist !");
    }

    public EntityNotExistException(EntityType entityType, String entityId) {
        super("Entity of type " + entityType.getName() + " and id " + entityId + " does not exist !");
    }
}
