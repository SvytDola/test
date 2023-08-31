package com.example.demo.mapper;

import com.example.demo.config.MappersConfig;
import com.example.demo.controller.dto.author.AuthorResponse;
import com.example.demo.entity.AuthorEntity;
import org.mapstruct.Mapper;

@Mapper(config = MappersConfig.class)
public interface AuthorMapper {

    AuthorResponse toResponse(AuthorEntity authorEntity);
}

