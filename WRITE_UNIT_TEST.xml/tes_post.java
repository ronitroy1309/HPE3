import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.junit.jupiter.api.Test;

public class EmployeeControllerTest {

    // ...

    @Test
    public void shouldAddEmployee() throws Exception {
        String newEmployeeJson = "{\"employee_id\": \"5\", \"first_name\": \"Bob\", \"last_name\": \"Marley\", \"email\": \"bob.marley@example.com\", \"title\": \"Musician\"}";

        // Perform a POST request to /employees and expect a 201 CREATED status
        mockMvc.perform(post("/employees")
                .contentType(APPLICATION_JSON)
                .content(newEmployeeJson))
                .andExpect(status().isCreated())
                .andExpect(content().string("Employee added successfully"));
    }
}
