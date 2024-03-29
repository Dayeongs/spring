package com.example.reply;

import com.example.common.BaseDateTimeEntity;
import com.example.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
// Oracle에서 테이블, 컬럼, 시퀀스 이름은 30글자를 넘으면 안된다.
@Entity
@Table(name = "board_post_reply_voters")
@SequenceGenerator(
		name = "reply_voter_pk_generator",
		sequenceName = "board_post_reply_voters_seq",
		initialValue = 1,
		allocationSize = 1
)
@Getter
@Setter
public class ReplyVoter extends BaseDateTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reply_voter_pk_generator")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "reply_id", nullable = false)
	private Reply reply;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

}
