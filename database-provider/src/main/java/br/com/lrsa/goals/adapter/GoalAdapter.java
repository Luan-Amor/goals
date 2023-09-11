package br.com.lrsa.goals.adapter;

import br.com.lrsa.goals.domain.dto.GoalDto;
import br.com.lrsa.goals.domain.dto.NewGoalDto;
import br.com.lrsa.goals.domain.dto.UpdateGoalDto;
import br.com.lrsa.goals.domain.exceptions.ResourceNotFoundExecption;
import br.com.lrsa.goals.domain.port.GoalsDatabase;
import br.com.lrsa.goals.entity.Goal;
import br.com.lrsa.goals.mapper.GoalMapper;
import br.com.lrsa.goals.repository.GoalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class GoalAdapter implements GoalsDatabase {

    private final GoalRepository repository;

    private final GoalMapper mapper;

    @Override
    public GoalDto add(NewGoalDto dto) {
        Goal newGoal = mapper.toEntity(dto);
        Goal entity = repository.save(newGoal);
        return mapper.toDto(entity);
    }

    @Override
    public GoalDto findById(Integer id) {
        Goal entity = repository.findById(id).get();
        return mapper.toDto(entity);
    }

    @Override
    public List<GoalDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public GoalDto update(Integer id, UpdateGoalDto dto) {
        Optional<Goal> entity = repository.findById(id);

        if(entity.isPresent()){
            Goal goal = entity.get();
            mapper.update(goal, dto);
            repository.save(goal);
            return mapper.toDto(goal);
        }

        throw new ResourceNotFoundExecption("Resource Not Found");
    }

    @Override
    public void delete(Integer id) {

        repository.findById(id)
                .ifPresent(repository::delete);
    }
}
