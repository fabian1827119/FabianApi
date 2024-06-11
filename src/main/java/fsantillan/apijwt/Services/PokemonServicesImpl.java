package fsantillan.apijwt.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import fsantillan.apijwt.Common.Models.PokemonModel;
import fsantillan.apijwt.Common.Models.Post;

@Service
public class PokemonServicesImpl implements PokemonServices{

    @Value("${url.pokemon}")
    private String pokemonUrl;

    @Override
    public PokemonModel getPokemonName(String name) {
        try{
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<PokemonModel> restPokemon= restTemplate.getForEntity(pokemonUrl+name, PokemonModel.class);
            PokemonModel pokemon = restPokemon.getBody();
            return pokemon;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getMessage());
        }
     }
     
     @Override
     public Post getPostId(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts/" + id;
        ResponseEntity<Post> test = restTemplate.getForEntity(url, Post.class);
        Post post = test.getBody();
        return post;      
    }

}

