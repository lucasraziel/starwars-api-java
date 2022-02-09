package com.api.starwars.planet.model.mongo;

import com.api.starwars.planet.model.domain.Planet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Duration;
import java.time.LocalDateTime;

@Document(collection = "planets")
@Data
@Builder
@AllArgsConstructor
public class MongoPlanet {

    @Id
    public String id;

    @Indexed(unique = true)
    private final String name;
    private final String climate;
    private final String terrain;
    private final Integer movieAppearances;

    @Field("created")
    @CreatedDate
    private LocalDateTime creationDate;


    public Planet toDomain() {
        LocalDateTime now = LocalDateTime.now();
        long daysBetween = Duration.between(creationDate, now).toDays();

        return new Planet(
                this.id,
                this.name,
                this.terrain,
                this.climate,
                this.movieAppearances,
                daysBetween
        );
    }

    public static MongoPlanet fromDomain(Planet planet) {
        return new MongoPlanet(
                planet.id(),
                planet.name(),
                planet.terrain(),
                planet.climate(),
                planet.movieAppearances(),
                null
        );
    }


}
