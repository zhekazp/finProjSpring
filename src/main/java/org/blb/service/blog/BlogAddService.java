package org.blb.service.blog;

import lombok.AllArgsConstructor;
import org.blb.DTO.blog.BlogAddRequestDTO;
import org.blb.DTO.blog.BlogResponseDTO;
import org.blb.models.blog.Blog;
import org.blb.models.region.Region;
import org.blb.models.user.User;
import org.blb.repository.RegionRepository;
import org.blb.repository.blog.BlogRepository;
import org.blb.service.region.FindRegionService;
import org.blb.service.user.UserFindService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BlogAddService {
    private final RegionRepository regionRepository;
    private final FindRegionService findRegionService;
    BlogRepository blogRepository;
    UserFindService userFindService;


    public BlogResponseDTO addBlog(BlogAddRequestDTO blog) {
        User user = userFindService.findUserById(blog.getAuthor());
        Region region = findRegionService.findRegionById(blog.getRegion());
        Blog newBlog = blog.dtoToBlog(user, region);
        return new BlogResponseDTO(blogRepository.save(newBlog).getId());
    }
}
