package co.edu.udea.gestioninvestigacion.api.controller;

import co.edu.udea.gestioninvestigacion.api.model.Categoria;
import co.edu.udea.gestioninvestigacion.api.service.impl.CategoriaServiceInt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CategoriaController.class)
public class CategoriaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoriaServiceInt categoriaService;

    List<Categoria> mockCategoria = new ArrayList<>();

    @Test
    public void retrieveCategorias() throws Exception{

        mockCategoria.add(new Categoria("Electronica","Agroindustria"));
        mockCategoria.add(new Categoria("Educación", "TIC"));

        Mockito.when(
                categoriaService.getCategorias()
        ).thenReturn(mockCategoria);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/categorias").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "[{materia:Electronica,tema:Agroindustria},{materia:Educación,tema:TIC}]";

        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    }

}
