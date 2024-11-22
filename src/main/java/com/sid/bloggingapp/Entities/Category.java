package com.sid.bloggingapp.Entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(nullable = false, unique = true)
    private String categoryTitle;

    @Column(length = 1000)
    private String categoryDescription;

    // mapped With Post
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<PostEntitty> posts = new ArrayList<>();

    public Category() {
    }

    public Category(Integer categoryId, String categoryTitle, String categoryDescription, List<PostEntitty> posts) {
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.categoryDescription = categoryDescription;
        this.posts = posts;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public List<PostEntitty> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntitty> posts) {
        this.posts = posts;
    }

    // getters and setters

}
