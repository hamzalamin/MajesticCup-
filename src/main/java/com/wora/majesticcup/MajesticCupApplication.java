package com.wora.majesticcup;

import com.wora.majesticcup.entities.Team;
import com.wora.majesticcup.repositories.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.List;

@SpringBootApplication
public class MajesticCupApplication {

    public static void main(String[] args) {
        SpringApplication.run(MajesticCupApplication.class, args);
    }


//    @Bean
//    @Order(1)
//    CommandLineRunner save(TeamRepository teamRepository) {
//        return args -> {
//            List<Team> existingTeams = teamRepository.findByName("hamza");
//            if (existingTeams.isEmpty()) {
//                Team team = new Team("hamza AZZAs");
//                teamRepository.save(team);
//            }
//        };
//    }
//
//    @Bean
//    @Order(2)
//    CommandLineRunner findAll(TeamRepository teamRepository){
//        return args -> {
//            teamRepository.findAll()
//                    .forEach(System.out::println);
//        };
//
//    }


}
