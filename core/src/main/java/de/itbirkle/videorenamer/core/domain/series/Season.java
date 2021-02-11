package de.itbirkle.videorenamer.core.domain.series;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Season {

    private int season;
    private String name;
    private List<Episode> episodes;

}
