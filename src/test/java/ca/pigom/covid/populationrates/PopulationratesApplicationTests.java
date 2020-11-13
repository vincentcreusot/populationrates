package ca.pigom.covid.populationrates;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class PopulationratesApplicationTests {

    @Autowired
    private RateController rateController;
    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() {
        assertThat(rateController).isNotNull();
    }

    @Test
    void getRateCountry_Returns200() throws Exception {
        mvc.perform(get("/rates/france"))
                .andExpect(status().isOk());
    }

}
