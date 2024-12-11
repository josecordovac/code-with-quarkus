package org.acme.dominio;

public sealed abstract class Task permits SimpleTask, TimedTask {
    private final String id;

    public Task(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

final class TimedTask extends Task {
    private final String description;
    private final long durationInMinutes;

    public TimedTask(String id, String description, long durationInMinutes) {
        super(id);
        if (durationInMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }
        this.description = description;
        this.durationInMinutes = durationInMinutes;
    }

    public String getDescription() {
        return description;
    }

    public long getDurationInMinutes() {
        return durationInMinutes;
    }
}
