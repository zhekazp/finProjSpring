package org.blb.models.blog;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.blb.models.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
    private LocalDate publishedDate;
    private LocalDateTime editedDate;
    private int views;
    private int comments;

    public Blog(String title, String content, User author,  int views, int comments) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.publishedDate = LocalDate.now();
        this.editedDate = LocalDateTime.now();
        this.views = views;
        this.comments = comments;
    }
}
