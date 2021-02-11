package de.itbirkle.videorenamer.core.domain.series;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Episode {

    private int episode;
    private int totalEpisode;
    private String title;
    private String description;

}
