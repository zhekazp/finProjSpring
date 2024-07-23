package org.blb.DTO.blog;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.blb.models.blog.Blog;
import org.blb.models.region.Region;
import org.blb.models.user.User;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class BlogAddRequestDTO {
    @NotNull
    @Size(min = 2, max = 200)
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String content;
    @NotNull
    @Min(1)
    private Long author;
    @NotNull
    @Min(1)
    private Long region;


    public Blog dtoToBlog(User user, Region region){
       return Blog.builder()
                .title(title)
                .content(content)
                .author(user)
                .views(0)
                .region(region)
                .comments(0)
                .publishedDate(LocalDate.now())
                .editedDate(LocalDateTime.now())
                .build();
    }
}
