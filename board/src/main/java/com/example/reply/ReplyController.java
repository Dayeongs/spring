package com.example.reply;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.post.PostService;
import com.example.user.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {

	private final PostService postService;
	private final ReplyService replyService;
	private final UserService userService;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create/{postId}")
	public String create(@PathVariable("postId") Long postId, @RequestParam("content") String content, Principal principal) {
		
		Reply reply = replyService.createReply(content, postId, principal.getName());
		
		// 덧셈으로 연결하면 객체를 생성하기 때문에 덧셈을 사용하지 않기 위해서
		return String.format("redirect:/post/detail?id=%d#reply_%d", postId, reply.getId());
	}
	
}
