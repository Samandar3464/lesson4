package uz.pdp.dataabsemigration.serice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import uz.pdp.dataabsemigration.servie.AuthUserCreateDTO;

@SpringBootTest
@AutoConfigureMockMvc
class AuthUserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateUser() throws Exception {
        AuthUserCreateDTO userCreateDTO = new AuthUserCreateDTO();
        // Set userCreateDTO properties as needed

        mockMvc.perform(MockMvcRequestBuilders.post("/api/authuser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userCreateDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    // Similar tests for other controller methods
}
