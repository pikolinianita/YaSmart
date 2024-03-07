package pl.lcc.yasmart.entity;

import java.beans.ConstructorProperties;
import java.util.List;
import java.util.UUID;

public record TaskCreateDTO(String name, String description, List<UUID> tags) {

    @ConstructorProperties({"name", "description", "tags"})
    public TaskCreateDTO(String name, String description, List<UUID> tags) {
        this.name = name;
        this.description = description;
        this.tags = tags;
    }
}
