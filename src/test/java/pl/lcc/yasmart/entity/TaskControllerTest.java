package pl.lcc.yasmart.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void createTaskTest() throws Exception {
     //Given
     var x1 = """
     {"name" : "task", "description" : "important task"}
     """;

     var x2 = """
             {"name" : "task", "description" : "important task", "tags" : null}
             """;
     //When
        var response = mockMvc.perform(post("/api/v1/tasks/11112345-2222-3333-4444-123456789012")
                .contentType("application/json")
                .content(x1)).andReturn().getResponse();


     //Then

    }

    @Test
    void createTaskTest2() throws Exception {
        //Given
        var x1 = """
     {"name" : "task", "description" : "important task"}
     """;

        var x2 = """
             {"name" : "task", "description" : "important task", "tags" : null}
             """;
        //When
        var response = mockMvc.perform(post("/api/v1/tasks/11112345-2222-3333-4444-123456789012")
                .contentType("application/json")
                .content(x2)).andReturn().getResponse();


        //Then

    }

}