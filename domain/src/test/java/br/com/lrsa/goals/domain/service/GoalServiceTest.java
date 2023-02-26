package br.com.lrsa.goals.domain.service;

import br.com.lrsa.goals.domain.dto.GoalDto;
import br.com.lrsa.goals.domain.port.GoalsDatabase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GoalServiceTest {

    @InjectMocks
    private GoalsService service;

    @Mock
    private GoalsDatabase database;

    @Test
    public void shouldReturnAGoal_withSuccess(){
        when(database.findById(1)).thenReturn(buildGoalDto());

        service.getGoalById(1);

        verify(database).findById(1);
    }

    private GoalDto buildGoalDto(){
        GoalDto dto = new GoalDto();
        dto.setId(1);
        dto.setDone(false);
        dto.setTitle("Mock");
        dto.setDescription("Mock Goal");
        return dto;
    }
}
