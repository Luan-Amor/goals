package br.com.lrsa.goals.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateGoalDto {

    private String title;
    private String description;
    private boolean done;
}
