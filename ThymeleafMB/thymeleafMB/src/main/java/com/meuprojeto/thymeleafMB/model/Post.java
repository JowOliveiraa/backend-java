package com.meuprojeto.thymeleafMB.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "post")
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @Length(max = 30)
    private String title;
    @NotBlank
    @Length(max = 30)
    private String author;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
    @NotBlank
    @Lob
    private String text;

    public Post(Post post) {
        this.title = post.getTitle();
        this.author = post.getAuthor();
        this.date = LocalDate.now();
        this.text = post.getText();
    }
}
