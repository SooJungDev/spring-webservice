package com.example.webservice.web;

import com.example.webservice.domain.posts.PostsRepository;
import com.example.webservice.dto.posts.PostSaveRequestDto;
import com.example.webservice.dto.posts.PostsMainResponseDto;
import com.example.webservice.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;
    private PostService postService;

    @GetMapping("/hello")
    public String hello() {
        return "helloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostSaveRequestDto dto) {
        return postService.save(dto);
    }

    @GetMapping("/getPostList")
    public List<PostsMainResponseDto> getList(){
        return postService.findAllDesc();
    }
}
