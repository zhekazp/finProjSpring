package org.blb.repository;


import org.blb.models.blog.BlogComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BlogCommentRepository extends JpaRepository<BlogComment, Integer> {
}
