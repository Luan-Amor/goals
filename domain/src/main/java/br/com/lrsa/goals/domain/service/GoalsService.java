package br.com.lrsa.goals.domain.service;

import br.com.lrsa.goals.domain.dto.GoalDto;
import br.com.lrsa.goals.domain.dto.NewGoalDto;
import br.com.lrsa.goals.domain.dto.UpdateGoalDto;
import br.com.lrsa.goals.domain.exceptions.ResourceNotFoundExecption;
import br.com.lrsa.goals.domain.port.Goals;
import br.com.lrsa.goals.domain.port.GoalsDatabase;
import br.com.lrsa.goals.domain.port.exception.GoalsDatabaseException;
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
        }catch (GoalsDatabaseException e){
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
        try{
            return database.add(dto);
        }catch (GoalsDatabaseException exception){
            throw new RuntimeException();
        }
    }

    @Override
    public GoalDto updateGoal(Integer id, UpdateGoalDto dto) {
        try {
            return database.update(id, dto);
        }catch (GoalsDatabaseException exception){
            throw new RuntimeException();
        }
    }

    @Override
    public void remove(Integer id) {
        try{
            database.delete(id);
        }catch (GoalsDatabaseException e){
            throw new RuntimeException();
        }
    }
}
