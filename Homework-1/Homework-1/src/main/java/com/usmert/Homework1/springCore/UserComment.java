package com.usmert.Homework1.springCore;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "USER_COMMENT")
public class UserComment {

    @Id
    @GeneratedValue(generator = "UserComment")
    @SequenceGenerator(name = "UserComment", sequenceName = "USER_COMMENT_ID_SEQ")
    private Long userCommentId;

    @Column(name="COMMENT",length = 500, nullable = false)
    private String userComment;

    @Column(name="COMMENT_DATE")
    @Temporal(TemporalType.DATE)
    private Date userCommentDate;

    @Column(name="PRODUCT_ID")
    private Long productID;

    @ManyToOne
    @JoinColumn(name = "ID_USER", referencedColumnName = "user_id")
    private User user;


}
