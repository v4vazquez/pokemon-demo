package com.techelevator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Pokemon;
import com.techelevator.model.PokemonDetail;
import com.techelevator.model.Results;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestPokeApiService implements PokeApiService{

    RestTemplate rt = new RestTemplate();
    private final String API_URL ="https://pokeapi.co/api/v2/pokemon/";

    @Override
    public List<Pokemon> getPokemon() {
        String response = rt.getForObject(API_URL,String.class);

        ObjectMapper mapper = new ObjectMapper(); //want to take the tree and take a node
        List<Pokemon> pokemonList = new ArrayList<>(); //creates data structure to get returning
        try {
            JsonNode jsonNode = mapper.readTree(response); //turns the string resposne into a tree with nodes for us to grab
            JsonNode root = jsonNode.path("results");
            for (int i = 0; i < root.size() ; i++) {
                //root is "results" array
                //path(i) --what array element
                //path("name" node called name
                String name = root.path(i).path("name").asText();
                String url = root.path(i).path("url").asText();
                int id = calculateId(url);
                //create a pokemon Object and set the values
                Pokemon temp = new Pokemon();
                temp.setId(id);
                temp.setName(name);
                temp.setUrl(url);
                pokemonList.add(temp);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return pokemonList;
    }

        public int calculateId(String url){
            int pokemonIndex = url.indexOf("pokemon");
            String pokemonString = url.substring(pokemonIndex);
            int slashIndex = pokemonString.indexOf("/");
            String number = pokemonString.substring(slashIndex + 1,pokemonString.length()-1);

            int id = Integer.parseInt(number);
                return id;
        }


    @Override
    public PokemonDetail getPokemonDetailById(int id) {
        PokemonDetail pokemonDetail = rt.getForObject(API_URL + id, PokemonDetail.class);
//        System.out.println(pokemonDetail);
        return pokemonDetail;
    }

    @Override
    public List<Pokemon> getMorePokemon(int startVal, int endVal) {
        Results results  = rt.getForObject(API_URL + "?offset=" + startVal + "&limit=20", Results.class);

        List<Pokemon> list = results.getResults();
        for(Pokemon item: list){
            int id = calculateId(item.getUrl());

            item.setId(id);
        }
        return list;
    }


}
