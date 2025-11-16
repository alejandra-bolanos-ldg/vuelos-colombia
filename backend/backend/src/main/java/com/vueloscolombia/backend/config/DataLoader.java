package com.vueloscolombia.backend.config;

import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.vueloscolombia.backend.model.Vuelo;
import com.vueloscolombia.backend.repository.VueloRepository;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private VueloRepository vueloRepository;

    @Override
    public void run(String... args) {

        if (vueloRepository.count() == 0) {
            Vuelo v1 = new Vuelo("Bogota", "Medellin", 300000, "12:00", "14:00", 50, "2025-01-01");
            Vuelo v2 = new Vuelo("Cali", "Cartagena", 350000, "15:00", "17:00", 60, "2025-01-02");

            vueloRepository.saveAll(List.of(v1, v2));
        }
    }
}
