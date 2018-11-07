package com.example.webservice.service;

import com.example.webservice.domain.posts.PostsRepository;
import com.example.webservice.dto.posts.PostSaveRequestDto;
import com.example.webservice.dto.posts.PostsMainResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }

}
