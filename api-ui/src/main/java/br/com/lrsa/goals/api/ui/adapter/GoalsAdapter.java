package br.com.lrsa.goals.api.ui.adapter;

import br.com.lrsa.goals.domain.dto.GoalDto;
import br.com.lrsa.goals.domain.dto.NewGoalDto;
import br.com.lrsa.goals.domain.dto.UpdateGoalDto;
import br.com.lrsa.goals.domain.port.Goals;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
@Validated
public class GoalsAdapter {

    private final Goals service;

    public GoalDto getGoal(Integer id){
        return service.getGoalById(id);
    }

    public List<GoalDto> getAllGoals() {
        return service.findAll();
    }

    public GoalDto create(@Valid NewGoalDto dto){
        return service.createGoal(dto);
    }

    public GoalDto update(Integer id, UpdateGoalDto dto){
        return service.updateGoal(id, dto);
    }

    public void remove(Integer id) {
        service.remove(id);
    }
}
