package com.karthik.github.demo.h2.repository;

import com.karthik.github.demo.h2.entity.GitUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitUserRespository extends CrudRepository<GitUserEntity, Long> {
}
