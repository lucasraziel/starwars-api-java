package com.api.starwars.planets.repositories;


import com.api.starwars.planets.model.domain.Planet;
import com.api.starwars.planets.model.mongo.MongoPlanet;

import java.util.Optional;

public interface IPlanetRepository  {

    Long count();

    Optional<MongoPlanet> findByName(String name);

    Optional<MongoPlanet> findbyId(String id);

    MongoPlanet save(Planet planet);

    void deleteById(String id);
}
