package org.blb.service.blog;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class BlogUpdateService {
//    private final BlogFindService blogFindService;
//    private final UserFindService userFindService;
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
//    public void remove(BlogRequestRemoveDTO blogDTO) {
//        blogFindService.findById(blogDTO.getId());
//        blogRepository.deleteById(blogDTO.getId());
//    }
}
