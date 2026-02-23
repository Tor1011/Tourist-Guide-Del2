package com.example.touristguidedel2.controller;

import com.example.touristguidedel2.model.Category;
import com.example.touristguidedel2.model.TouristAttraction;
import com.example.touristguidedel2.service.TouristService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class TouristControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    TouristService service;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAttractions() throws Exception {
        ArrayList<TouristAttraction> mockList = new ArrayList<>();
        mockList.add(new TouristAttraction("Tivoli", "Cool sted", "København", List.of(Category.CULTURE)));
        when(service.getAttractions()).thenReturn(mockList);

        mockMvc.perform(get("/attractions"))
                .andExpect(status().isOk())
                .andExpect(view().name("showattractions"))
                .andExpect(model().attributeExists("attractions"))
                .andExpect(model().attribute("attractions", mockList));

        verify(service).getAttractions();
    }

    @Test
    void findAttractionByName() throws Exception {
        TouristAttraction mockAttraction = new TouristAttraction("Tivoli", "Cool sted", "København", List.of(Category.CULTURE));
        when(service.findAttractionByName("Tivoli")).thenReturn(mockAttraction);

        mockMvc.perform(get("/attractions/Tivoli"))
                .andExpect(status().isOk())
                .andExpect(view().name("attraction"))
                .andExpect(model().attributeExists("attraction"))
                .andExpect(model().attribute("attraction", mockAttraction));

        verify(service).findAttractionByName("Tivoli");

    }

    @Test
    void findTags() throws Exception {
        TouristAttraction mockAttraction = new TouristAttraction("Tivoli", "Cool sted", "København", List.of(Category.CULTURE));
        when(service.findAttractionByName("Tivoli")).thenReturn(mockAttraction);

        mockMvc.perform(get("/attractions/Tivoli/tags"))
                .andExpect(status().isOk())
                .andExpect(view().name("showtags"))
                .andExpect(model().attributeExists("attraction"))
                .andExpect(model().attribute("attraction", mockAttraction));

        verify(service).findAttractionByName("Tivoli");
    }

    @Test
    void addAttraction() throws Exception {
        List<Category> mockTags = List.of(Category.values());
        when(service.getTags()).thenReturn(mockTags);

        mockMvc.perform(get("/attractions/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("addnewattraction"))
                .andExpect(model().attributeExists("tags"))
                .andExpect(model().attribute("tags",mockTags));
    }

    @Test
    void saveAttraction() {
    }

    @Test
    void editAttraction() {
    }

    @Test
    void updateAttraction() {
    }

    @Test
    void deleteAttraction() {
    }
}