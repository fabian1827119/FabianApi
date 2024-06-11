package fsantillan.apijwt.Services;

import fsantillan.apijwt.Common.Models.PokemonModel;
import fsantillan.apijwt.Common.Models.Post;

public interface PokemonServices {
    PokemonModel getPokemonName(String name);
    Post getPostId(int id);
}
