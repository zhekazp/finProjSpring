package org.blb.DTO.blog.blogs;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.blb.models.region.Region;
import org.blb.models.user.User;

import java.time.LocalDate;

@Data
@Schema(name = "Blog Response", description = "Return inserted blog id")
public class BlogResponseDTO {
    @Schema(description = "Blog id", example = "7")
    private Long id;
    private String title;
    private LocalDate publishedDate;
    private Integer views;
    private Integer comments;
    private String authorName;
    private String regionName;

    public BlogResponseDTO(Long id, String title, LocalDate publishedDate,
                           Integer views, Integer comments, User author, Region region) {
        this.id = id;
        this.title = title;
        this.publishedDate = publishedDate;
        this.views = views;
        this.comments = comments;
        this.authorName =author.getName();
        this.regionName = region.getRegionName();
    }
}

