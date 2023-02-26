package br.com.lrsa.goals.api.ui.controller;

import br.com.lrsa.goals.api.ui.adapter.GoalsAdapter;
import br.com.lrsa.goals.domain.dto.GoalDto;
import br.com.lrsa.goals.domain.dto.NewGoalDto;
import br.com.lrsa.goals.domain.dto.UpdateGoalDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/ui/v1/goals")
@RequiredArgsConstructor
public class GoalsController {

    private final GoalsAdapter adapter;

    @GetMapping("/{id}")
    public GoalDto getGoal(@PathVariable Integer id){
        return adapter.getGoal(id);
    }

    @GetMapping("/")
    public List<GoalDto> getAllGoal(){
        return adapter.getAllGoals();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GoalDto create(@RequestBody NewGoalDto dto){
        return adapter.create(dto);
    }

    @PutMapping("/{id}")
    public GoalDto update(@PathVariable Integer id, @RequestBody UpdateGoalDto dto){
        return adapter.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        adapter.remove(id);
    }
}
