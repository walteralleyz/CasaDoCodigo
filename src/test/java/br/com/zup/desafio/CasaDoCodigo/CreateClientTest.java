package br.com.zup.desafio.CasaDoCodigo;

import br.com.zup.desafio.CasaDoCodigo.country.CountryDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
@AutoConfigureMockMvc
public class CreateClientTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void naoDeveriaCadastrarUmClienteComCPFInvalido() throws Exception {
        URI uri = new URI("/api/client");
        String payload = "{" +
            "\"name\": \"walter\"," +
            "\"lastname\": \"santos\"," +
            "\"email\": \"walter@mail.com\"," +
            "\"tipoPessoa\": \"FISICA\"," +
            "\"doc\": \"11111111111\"," +
            "\"address\": \"joao palmeira\"," +
            "\"addressComplement\": \"222\"," +
            "\"city\": \"robesval\"," +
            "\"country_id\": 1," +
            "\"state_id\": 1," +
            "\"phone\": \"47999225555\"," +
            "\"cep\": \"88340-416\"" +
            "}";

        mvc.perform(MockMvcRequestBuilders
            .post(uri)
            .contentType(MediaType.APPLICATION_JSON)
            .content(payload)
        ).andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    public void naoDeveriaCadastrarComCEPInvalido() throws Exception {
        URI uri = new URI("/api/client");
        String payload = "{" +
            "\"name\": \"walter\"," +
            "\"lastname\": \"santos\"," +
            "\"email\": \"walter@mail.com\"," +
            "\"tipoPessoa\": \"FISICA\"," +
            "\"doc\": \"09547284916\"," +
            "\"address\": \"joao palmeira\"," +
            "\"addressComplement\": \"222\"," +
            "\"city\": \"robesval\"," +
            "\"country_id\": 1," +
            "\"state_id\": 1," +
            "\"phone\": \"47999225555\"," +
            "\"cep\": \"2222222\"" +
            "}";

        mvc.perform(MockMvcRequestBuilders
            .post(uri)
            .contentType(MediaType.APPLICATION_JSON)
            .content(payload)
        ).andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    public void naoDeveriaCadastrarComTelefoneInvalido() throws Exception {
        URI uri = new URI("/api/client");
        String payload = "{" +
            "\"name\": \"walter\"," +
            "\"lastname\": \"santos\"," +
            "\"email\": \"walter@mail.com\"," +
            "\"tipoPessoa\": \"FISICA\"," +
            "\"doc\": \"09547284916\"," +
            "\"address\": \"joao palmeira\"," +
            "\"addressComplement\": \"222\"," +
            "\"city\": \"robesval\"," +
            "\"country_id\": 1," +
            "\"state_id\": 1," +
            "\"phone\": \"472849\"," +
            "\"cep\": \"88340-416\"" +
            "}";

        mvc.perform(MockMvcRequestBuilders
            .post(uri)
            .contentType(MediaType.APPLICATION_JSON)
            .content(payload)
        ).andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    public void deveriaCadastrarClienteValido() throws Exception {
        URI uri = new URI("/api/client");
        String payload = "{" +
            "\"name\": \"huguinho\"," +
            "\"lastname\": \"zezinho luizinho\"," +
            "\"email\": \"donald@mail.com\"," +
            "\"tipoPessoa\": \"FISICA\"," +
            "\"doc\": \"221.196.580-64\"," +
            "\"address\": \"joao palmeira\"," +
            "\"addressComplement\": \"222\"," +
            "\"city\": \"robesval\"," +
            "\"country_id\": 1," +
            "\"state_id\": 1," +
            "\"phone\": \"55 88892-6637\"," +
            "\"cep\": \"88888-111\"" +
            "}";

        mvc.perform(MockMvcRequestBuilders
            .post(uri)
            .contentType(MediaType.APPLICATION_JSON)
            .content(payload)
        ).andExpect(MockMvcResultMatchers.status().is(201));
    }
}
