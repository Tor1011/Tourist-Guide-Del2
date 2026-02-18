package com.example.touristguidedel2.service;

import com.example.touristguidedel2.model.Category;
import com.example.touristguidedel2.model.TouristAttraction;
import com.example.touristguidedel2.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TouristService {
    private final TouristRepository repository;


    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public ArrayList<TouristAttraction> getAttractions() {
        return repository.getAttractions();
    }

    public TouristAttraction findAttractionByName(String name) {
        return repository.findAttractionByName(name);
    }

    public void saveAttraction(TouristAttraction attraction) {
        repository.saveAttraction(attraction);
    }

    public void updateAttraction(TouristAttraction attraction){
        repository.updateAttraction(attraction);
    }

    public void deleteAttraction(String nameOfAttraction){
        repository.deleteAttraction(nameOfAttraction);
    }

    public List<String> getCities() {
        return repository.getCities();
    }

    public List<Category>getTags(){
        return repository.getTags();
    }

}
