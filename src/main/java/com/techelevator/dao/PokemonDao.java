package com.techelevator.dao;

import com.techelevator.model.PokemonDto;

public interface PokemonDao {

    //will later do crud abilities besides save
    void savePokemon(PokemonDto dto);
}
