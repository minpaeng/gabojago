package com.hanium.gabojago.domain;

import lombok.*;

import javax.persistence.*;

@ToString(exclude = {"user", "post"})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column
    private String context;

    @Builder
    public Comment(User user, Post post, String context) {
        this.user = user;
        this.post = post;
        this.context = context;
    }

    public void updateContext(String context) {
        this.context = context;
    }
}