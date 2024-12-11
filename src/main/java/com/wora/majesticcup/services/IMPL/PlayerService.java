package com.wora.majesticcup.services.IMPL;

import com.wora.majesticcup.exceptions.EntityNotFoundException;
import com.wora.majesticcup.mappers.PlayerMapper;
import com.wora.majesticcup.models.DTOs.player.CreatePlayerDto;
import com.wora.majesticcup.models.DTOs.player.PlayerDto;
import com.wora.majesticcup.models.DTOs.player.UpdatePlayerDto;
import com.wora.majesticcup.models.entities.embeddedDocuments.Player;
import com.wora.majesticcup.repositories.PlayerRepository;
import com.wora.majesticcup.services.INTER.IPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService implements IPlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public PlayerDto save(CreatePlayerDto createPlayerDto) {
        Player player = playerMapper.toEntity(createPlayerDto);
        Player savedPlayer = playerRepository.save(player);
        return playerMapper.toDto(savedPlayer);
    }

    @Override
    public PlayerDto findById(String id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player", id));
        return playerMapper.toDto(player);
    }

    @Override
    public PlayerDto update(UpdatePlayerDto updatePlayerDto, String id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player", id));

        player.setName(updatePlayerDto.name());
        player.setSurname(updatePlayerDto.surname());
        player.setPosition(updatePlayerDto.position());
        player.setNumber(updatePlayerDto.number());

        Player updatedPlayer = playerRepository.save(player);
        return playerMapper.toDto(updatedPlayer);
    }

    @Override
    public List<PlayerDto> findAll(Integer pageNumber, Integer size) {
        PageRequest pageable = PageRequest.of(pageNumber, size);
        return playerRepository.findAll(pageable).stream()
                .map(playerMapper::toDto)
                .toList();
    }

    @Override
    public void delete(String id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player", id));
        playerRepository.delete(player);
    }
}
