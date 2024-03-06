package pl.lcc.yasmart.entity;

import pl.lcc.yasmart.common.flow.ScenarioState;
import pl.lcc.yasmart.common.tag.Tag;

import java.util.List;
import java.util.UUID;

public record ProjectSummaryDTO(UUID id, String name, ScenarioState state, long totalTasks, long finishedTasks)
{
}
