package com.example.demo.service;

import com.example.demo.controller.dto.author.AuthorResponse;
import com.example.demo.entity.AuthorEntity;
import com.example.demo.mapper.AuthorMapper;
import com.example.demo.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorMapper authorMapper;
    private final AuthorRepository authorRepository;

    public AuthorResponse getAuthorById(Integer id) {
        AuthorEntity authorEntity = authorRepository.findById(id).orElseThrow();
        return authorMapper.toResponse(authorEntity);
    }
}
