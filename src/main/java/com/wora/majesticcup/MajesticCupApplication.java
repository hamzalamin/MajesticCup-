package com.wora.majesticcup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
