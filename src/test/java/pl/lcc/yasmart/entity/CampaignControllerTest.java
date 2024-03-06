package pl.lcc.yasmart.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import pl.lcc.yasmart.common.loader.DataPreLoader;
import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class CampaignControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    CampaignRepository campRepo;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    DataPreLoader dataLoader;

    @Test
    @WithMockUser(username="user")
    void test() throws Exception {

            //Given/When
        var response = mockMvc.perform(get("/api/v1/campaigns")
                    .contentType("application/json")
                    )
             .andReturn().getResponse();
            //Then

        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.getContentAsString()).contains("Home", "Journey");
        }
    }
