package com.example.on_class.domain.model;

import java.util.List;

public class Bootcamp {
    private final Long id;
    private final String name;
    private final String description;
    private List<Capacity> capacities;

    public Bootcamp(Long id, String name, String description, List<Capacity> capacities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacities = capacities;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Capacity> getCapacities() {
        return capacities;
    }

    public void setCapacities(List<Capacity> capacities) {
        this.capacities = capacities;
    }
}
