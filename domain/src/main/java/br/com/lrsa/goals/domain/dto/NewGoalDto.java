package br.com.lrsa.goals.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewGoalDto {

    @NotNull
    @NotBlank
    private String title;

    private String description;
}
