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

import java.util.List;

import static javax.swing.UIManager.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
    void getAttractions() {
    }

    @Test
    void findAttractionByName() throws Exception {
        TouristAttraction attraction = new TouristAttraction("Tivoli", "Cool sted", "København", List.of(Category.CULTURE));
        when(service.findAttractionByName(anyString())).thenReturn(attraction);
        mockMvc.perform(get("/{name}"))
                .andExpect(status().isOk())
                .andExpect(view().name("attraction"))
                .andExpect(model().attribute("description"));

        verify(service).findAttractionByName(attraction);

    }

    @Test
    void findTags() {
    }

    @Test
    void addAttraction() {
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