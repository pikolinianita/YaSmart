package pl.lcc.yasmart.entity;

import pl.lcc.yasmart.common.flow.ScenarioState;

import java.util.UUID;

public record SprintSummaryDTO(UUID id, String name, ScenarioState state, long totalTasks, long finishedTasks)
{
}
