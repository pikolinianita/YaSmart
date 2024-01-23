package pl.lcc.yasmart.common.rtype;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import pl.lcc.yasmart.common.loader.DataPreLoader;
import pl.lcc.yasmart.common.rtype.RewardType;
import pl.lcc.yasmart.common.rtype.RewardTypeRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class RewardTypeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    RewardTypeRepository rtRepo;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    DataPreLoader dataLoader;

    @Autowired
    EntityManager em;

    @BeforeEach
    void resetDb() throws Exception {
        dataLoader.clean().run();
    }

    //TODO enable when github build is fixed.
    //@Test
    @WithMockUser(username="user")
    void GetStaticShouldReturnOk() throws Exception {
     //Given/When
        mockMvc.perform(get("/")
             .contentType("application/json"))
        //Then
             .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username="user")
    void GetShouldReturn200() throws Exception {
        //Given/When
        var response = mockMvc.perform(get("/api/v1/common/rewardTypes")
                        .contentType("application/json")
                )
                .andReturn().getResponse();
        //Then
        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.getContentAsString()).contains("Pizza", "Cash");
    }

    @Test
    @WithMockUser(username="user")
    void PostShouldReturn201() throws Exception {
        //Given/When
        var response = mockMvc.perform(post("/api/v1/common/rewardTypes")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(getRewardType()))
                )
                .andReturn().getResponse();
        //then
        assertThat(response.getStatus()).isEqualTo(201);
        assertThat(rtRepo.count()).isEqualTo(3);
    }

    @Test
    @WithMockUser(username="user")
    void DeleteShouldReturn200() throws Exception {
        //Given/When
        var response = mockMvc.perform(delete("/api/v1/common/rewardTypes/Pizza")
                        .contentType("application/json")
                )
                .andReturn().getResponse();
        //then
        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(rtRepo.count()).isEqualTo(1);
    }

    @Test
    @WithMockUser(username="user")
    void PutShouldReturn204() throws Exception {
        //Given/When
        var response = mockMvc.perform(put("/api/v1/common/rewardTypes/Pizza")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(getRewardType()))
                )
                .andReturn().getResponse();
        //then
        assertThat(response.getStatus()).isEqualTo(204);
        assertThat(rtRepo.findAll())
                .anyMatch(rt -> rt.getName().equals("Book"))
                .noneMatch(rt -> rt.getName().equals("Pizza"))
                .hasSize(2);
    }


    private RewardType getRewardType(){
        return new RewardType(null, "Book", "book", "0xFFFFFF",null);
    }

}
