package br.com.lrsa.goals.domain.port;

import br.com.lrsa.goals.domain.dto.GoalDto;
import br.com.lrsa.goals.domain.dto.NewGoalDto;
import br.com.lrsa.goals.domain.dto.UpdateGoalDto;
import br.com.lrsa.goals.domain.port.exception.GoalsDatabaseException;

import java.util.List;

public interface GoalsDatabase {

    GoalDto add(NewGoalDto dto) throws GoalsDatabaseException;

    GoalDto findById(Integer id) throws GoalsDatabaseException;

    List<GoalDto> findAll();

    GoalDto update(Integer id, UpdateGoalDto dto) throws GoalsDatabaseException;

    void delete(Integer id) throws GoalsDatabaseException;
}
