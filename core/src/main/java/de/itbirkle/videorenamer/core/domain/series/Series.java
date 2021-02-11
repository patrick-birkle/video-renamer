package de.itbirkle.videorenamer.core.domain.series;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Series {

    private String title;
    private String description;
    private String status;
    private int numOfSeasons;
    private int numOfEpisodes;
    private List<String> genres;
    private List<Season> seasons;

}
