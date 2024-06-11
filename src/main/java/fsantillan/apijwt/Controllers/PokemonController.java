package fsantillan.apijwt.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fsantillan.apijwt.Common.Models.PokemonModel;
import fsantillan.apijwt.Services.PokemonServices;

@RestController
@RequestMapping(value = "/api/pokemon")
public class PokemonController {

    @Autowired
    private final PokemonServices pokemonServices;

    
    public PokemonController(PokemonServices pokemonServices) {
        this.pokemonServices = pokemonServices;
    }

 

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<PokemonModel> getPokemonName(@PathVariable String name) {
        PokemonModel pokemon = pokemonServices.getPokemonName(name);
        return ResponseEntity.ok(pokemon);
    }
    

}
