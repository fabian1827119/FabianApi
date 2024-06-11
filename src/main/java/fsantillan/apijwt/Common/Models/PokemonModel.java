package fsantillan.apijwt.Common.Models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokemonModel {
    int id;
    String name;
    int weight;
    int base_experience;
    int height;
    boolean is_default;
    String location_area_encounters;
    int order;
    List<Object> moves;
    List<Object> past_abilities;
    List<Object> past_types;
    List<Object> stats;
    List<Object> types;
    Object species;
}
