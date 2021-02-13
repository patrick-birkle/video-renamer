package de.itbirkle.videorenamer.core.domain.series;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class Season {

    private int season;
    private String title;
    private String description;
    private List<Episode> episodes;

    public Season() {
        this.title = "";
        this.description = "";
        this.episodes = new ArrayList<>();
    }
}
