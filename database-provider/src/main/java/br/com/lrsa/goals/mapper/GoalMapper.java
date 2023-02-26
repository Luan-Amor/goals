package br.com.lrsa.goals.mapper;

import br.com.lrsa.goals.domain.dto.GoalDto;
import br.com.lrsa.goals.domain.dto.NewGoalDto;
import br.com.lrsa.goals.domain.dto.UpdateGoalDto;
import br.com.lrsa.goals.entity.Goal;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GoalMapper {

    Goal toEntity(GoalDto dto);

    Goal toEntity(NewGoalDto dto);

    GoalDto toDto(Goal entity);

    void update(@MappingTarget Goal entity, UpdateGoalDto dto);
}
