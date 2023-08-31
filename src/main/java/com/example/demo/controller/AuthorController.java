package com.example.demo.controller;

import com.example.demo.controller.dto.author.AuthorResponse;
import com.example.demo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/{id}")
    public AuthorResponse getAuthorById(@PathVariable Integer id) {
        return authorService.getAuthorById(id);
    }
}
