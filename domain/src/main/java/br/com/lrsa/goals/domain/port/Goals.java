package br.com.lrsa.goals.domain.port;

import br.com.lrsa.goals.domain.dto.GoalDto;
import br.com.lrsa.goals.domain.dto.NewGoalDto;
import br.com.lrsa.goals.domain.dto.UpdateGoalDto;

import java.util.List;

public interface Goals {

    GoalDto getGoalById(Integer id);

    List<GoalDto> findAll();

    GoalDto createGoal(NewGoalDto dto);

    GoalDto updateGoal(Integer id, UpdateGoalDto dto);

    void remove(Integer id);


}
