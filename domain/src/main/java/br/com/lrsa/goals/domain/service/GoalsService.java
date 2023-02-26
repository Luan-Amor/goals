package br.com.lrsa.goals.domain.service;

import br.com.lrsa.goals.domain.dto.GoalDto;
import br.com.lrsa.goals.domain.dto.NewGoalDto;
import br.com.lrsa.goals.domain.dto.UpdateGoalDto;
import br.com.lrsa.goals.domain.exceptions.ResourceNotFoundExecption;
import br.com.lrsa.goals.domain.port.Goals;
import br.com.lrsa.goals.domain.port.GoalsDatabase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class GoalsService implements Goals {

    private final GoalsDatabase database;

    @Override
    public GoalDto getGoalById(Integer id) {
        try {
            return database.findById(id);
        }catch (NoSuchElementException e){
            log.debug("Goal not found for id: {}", id);
            throw new ResourceNotFoundExecption("Não foi possível encontrar o objetivo pelo id informado");
        }
    }

    @Override
    public List<GoalDto> findAll() {
        return database.findAll();
    }

    @Override
    public GoalDto createGoal(NewGoalDto dto) {
        return database.add(dto);
    }

    @Override
    public GoalDto updateGoal(Integer id, UpdateGoalDto dto) {
        return database.update(id, dto);
    }

    @Override
    public void remove(Integer id) {
        database.delete(id);
    }
}
