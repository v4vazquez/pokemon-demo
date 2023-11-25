package com.techelevator.service;

import com.techelevator.model.Pokemon;
import com.techelevator.model.PokemonDetail;

import java.util.List;

public interface PokeApiService {

    //abstract methods
    //get request to get a list of pokemon
    List<Pokemon> getPokemon();

    PokemonDetail getPokemonDetailById(int id);

    List<Pokemon> getMorePokemon(int startVal, int endVal);
}
