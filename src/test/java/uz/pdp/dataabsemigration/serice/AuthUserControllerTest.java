package uz.pdp.dataabsemigration.serice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import uz.pdp.dataabsemigration.servie.AuthUserController;
import uz.pdp.dataabsemigration.servie.AuthUserCreateDTO;
import uz.pdp.dataabsemigration.servie.AuthUserService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(AuthUserController.class)
class AuthUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AuthUserService authUserService;

    @InjectMocks
    private AuthUserController authUserController;

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
