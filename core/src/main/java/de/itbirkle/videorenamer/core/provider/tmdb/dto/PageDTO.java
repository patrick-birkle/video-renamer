package de.itbirkle.videorenamer.core.provider.tmdb.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PageDTO {

    private int page;
    private int total_results;
    private int total_pages;

}
