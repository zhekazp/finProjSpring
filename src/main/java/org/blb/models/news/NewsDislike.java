package org.blb.models.news;

import org.blb.models.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "news_dislike")
public class NewsDislike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "news_id", referencedColumnName = "id")
    private NewsDataEntity newsData;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "news_dislike_user_id", referencedColumnName = "id")
    private User user;

}