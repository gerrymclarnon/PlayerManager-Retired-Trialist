package net.playermanager.config;

import net.playermanager.games.dao.ClubDAO;
import net.playermanager.games.services.ClubsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ClubsService clubsService() {
        ClubsService service = new ClubsService();
        service.setDao(new ClubDAO());
        return service;
    }	
}
