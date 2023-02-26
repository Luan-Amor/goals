package br.com.lrsa.goals.domain.port;

import br.com.lrsa.goals.domain.dto.GoalDto;
import br.com.lrsa.goals.domain.dto.NewGoalDto;
import br.com.lrsa.goals.domain.dto.UpdateGoalDto;

import java.util.List;

public interface GoalsDatabase {

    GoalDto add(NewGoalDto dto);

    GoalDto findById(Integer id);

    List<GoalDto> findAll();

    GoalDto update(Integer id, UpdateGoalDto dto);

    void delete(Integer id);
}
