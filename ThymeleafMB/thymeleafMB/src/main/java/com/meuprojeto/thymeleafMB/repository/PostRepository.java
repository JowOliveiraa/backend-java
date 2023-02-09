package com.meuprojeto.thymeleafMB.repository;

import com.meuprojeto.thymeleafMB.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}