package com.techelevator.controller;

import com.techelevator.dao.PokemonDao;
import com.techelevator.model.Pokemon;
import com.techelevator.model.PokemonDetail;
import com.techelevator.model.PokemonDto;
import com.techelevator.service.PokeApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PokemonController {

   @Autowired
   PokeApiService service;

   @Autowired
   PokemonDao dao;

   //testing with localhost:9000/pokemon
   @RequestMapping(path="/pokemon",method= RequestMethod.GET)
    public List<Pokemon> getAllPokemon(){
       return service.getPokemon();
   }

   @GetMapping("/pokemon/{id}")
   public PokemonDetail getPokemonDetailById(@PathVariable int id){
      return service.getPokemonDetailById(id);
   }

   @PostMapping("/pokemon")
   public void saveFavoritePokemon(@RequestBody PokemonDto pokemon){
      dao.savePokemon(pokemon);
   }

   @GetMapping("/pokemon/{startVal}/{endVal}")
   public List<Pokemon> getMorePokemon(@PathVariable int startVal,@PathVariable int endVal){
         return service.getMorePokemon(startVal, endVal);
   }

}
