package com.gunedu.book.springboot.web;

import com.gunedu.book.springboot.config.auth.LoginUser;
import com.gunedu.book.springboot.config.auth.dto.SessionUser;
import com.gunedu.book.springboot.domain.posts.PostsRepository;
import com.gunedu.book.springboot.service.posts.PostsService;
import com.gunedu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        //SessionUser user = (SessionUser) httpSession.getAttribute("user"); // 반복가능한 기능이기 때문에 위의 코드로 개선, @LoginUser
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        System.out.println(dto);

        return "posts-update";
    }
}
