package com.example.webservice.web;

import com.example.webservice.domain.posts.Posts;
import com.example.webservice.domain.posts.PostsRepository;
import com.example.webservice.dto.posts.PostSaveRequestDto;
import com.example.webservice.dto.posts.PostsMainResponseDto;
import com.example.webservice.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class WebRestController {

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
    public List<PostsMainResponseDto> getList() {
        return postService.findAllDesc();
    }

    @GetMapping("/findPost/{author}")
    public Posts findByAuthor(@PathVariable String author) {
        return postService.findByAuthor(author);
    }

    @DeleteMapping("/deletePost/{id}")
    public void deletePost(@PathVariable long id) {
        postService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllPost(long id) {
        postService.deleteAll();
    }
}
