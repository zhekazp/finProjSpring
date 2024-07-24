package org.blb.repository.blog;


import org.blb.DTO.blog.blogs.BlogResponseDTO;
import org.blb.DTO.blog.blogs.ContentResponseDTO;
import org.blb.models.blog.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Modifying
    @Query("UPDATE Blog b set b.comments = b.comments + 1 where b.id = :id" )
    public void updateComment(@Param("id") Integer id);
    @Modifying
    @Query("UPDATE Blog b set b.views = b.views + 1 where b.id = :id" )
    public void updateViews(@Param("id") Integer id);
    Optional<ContentResponseDTO> findBlogById(Long id);

}
