package org.acme.dominio;

public final class SimpleTask extends Task {
    private final String description;

    public SimpleTask(String id, String description) {
        super(id);
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or blank");
        }
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
