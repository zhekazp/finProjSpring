package org.blb.service.blog;

import lombok.AllArgsConstructor;
import org.blb.DTO.appDTO.StandardDelRequest;
import org.blb.DTO.blog.BlogUpdateDTO;
import org.blb.exeption.RestException;
import org.blb.models.blog.Blog;
import org.blb.models.region.Region;
import org.blb.models.user.Role;
import org.blb.models.user.User;
import org.blb.repository.RoleRepository;
import org.blb.repository.blog.BlogRepository;
import org.blb.service.region.FindRegionService;
import org.blb.service.user.UserFindService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BlogUpdateService {
    private final BlogFindService blogFindService;
    private final UserFindService userFindService;
    private final RoleRepository roleRepository;
    private final BlogRepository blogRepository;
    private final FindRegionService findRegionService;

    //    private BlogRepository blogRepository;
//
//    public void update(BlogRequestDTO blogDTO) {
//        if (blogDTO.getId() == null) {
//            throw new NullArgException("id");
//        }
//        // tot ge user dolgen bit
//        userFindService.findUserById(blogDTO.getAuthorId());
//        Blog blog = blogFindService.findById(blogDTO.getId());
//        blog.setContent(blogDTO.getContent());
//        blog.setEditedDate(LocalDateTime.now());
//        blogRepository.save(blog);
//    }
//    @Transactional
//    public void increaseComments(Integer blogId) {
//        blogRepository.updateComment(blogId);
//    }
//
//    @Transactional
//    public void increaseViews(Integer blogId) {
//        blogRepository.updateViews(blogId);
//    }
//
    public void remove(StandardDelRequest dto) {
        Blog blog = getBlogForUpdate(dto.getId());
        blogRepository.deleteById(blog.getId());
    }

    public void update(BlogUpdateDTO dto) {
        Blog blog = getBlogForUpdate(dto.getId());
        Region region = findRegionService.
                getRegionById(dto.getBlogAddRequestDTO().getRegion());
        dto.DtoToBlog(blog, region);
        blogRepository.save(blog);
    }

    private Blog getBlogForUpdate (Long id){
        User user = userFindService.getUserFromContext();
        Blog blog = blogFindService.findById(id);
        Role role = roleRepository.findByRole("ADMIN");
        if (user != blog.getAuthor() && user.getRole() != role){
            throw new RestException(HttpStatus.CONFLICT, "You dont have permission to dell this message");
        }
        return blog;
    }
}
