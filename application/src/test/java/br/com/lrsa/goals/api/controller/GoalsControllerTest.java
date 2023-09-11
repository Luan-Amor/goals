package br.com.lrsa.goals.api.controller;

import br.com.lrsa.goals.application.GoalsApplication;
import br.com.lrsa.goals.config.ContainersEnvironment;
import br.com.lrsa.goals.repository.GoalRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(
        classes = GoalsApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GoalsControllerTest extends ContainersEnvironment {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private GoalRepository repository;

    @Test
    void shouldCreateNewGoal_WithSuccess_thenStatus201() throws Exception {
        mvc.perform(post("/ui/v1/goals")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"title\": \"test\", \"description\": \"teste description\" }")
                .accept(MediaType.APPLICATION_JSON)
            ).andExpect(status().isCreated());
    }
    @Test
    void shouldThrowError_NullFieldRequired() throws Exception {

        mvc.perform(post("/ui/v1/goals")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"description\": \"teste description\" }")
                .accept(MediaType.APPLICATION_JSON)
            ).andExpect(status().isBadRequest());
    }

}
