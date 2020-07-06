package com.koszalka.crud.unit;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestBody;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.koszalka.crud.bo.CityBO;
import com.koszalka.crud.bo.ClientBO;
import com.koszalka.crud.persistence.dto.CityDTO;
import com.koszalka.crud.persistence.dto.ClientDTO;
import com.koszalka.crud.persistence.entities.CityEntity;
import com.koszalka.crud.persistence.entities.ClientEntity;
import com.koszalka.crud.rest.controllers.CityController;

import com.koszalka.crud.rest.controllers.ClientController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ClientBO clientBO;

    @InjectMocks
    private ClientController clientController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
    }

    @Test
    private void shortenerControllerGetGone() throws Exception {
        Mockito
                .when(clientBO.getCityByName("Blumenau"))
                .thenReturn(new ClientEntity());

        mockMvc
                .perform(MockMvcRequestBuilders.get("/v1/city/city-name/Blumenau"))
                .andExpect(status().isOk());
    }

    @Test
    private void cityControllerPost() throws Exception {

        ClientDTO data = new ClientDTO();
        data.setGender("M");
        data.setName("Raphael Koszalka");
        data.setBirthdate("03/10/1988");
        data.setCity(new CityEntity());

        this.mockMvc
                .perform(post("/v1/city/new")
                        .contentType(MediaType.APPLICATION_JSON).content(data.toString()))
                .andExpect(status().isCreated());
    }
}
