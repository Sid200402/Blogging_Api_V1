package com.sid.bloggingapp.Payloads;

import java.util.Date;

public class PostDto {
    private Integer postId;
    private String postTitle;
    private String postContent;
    private String imageName;
    private Date addDate;

    private CategoryDto category;
    private UserDto user;

    public PostDto(Integer postId, String postTitle, String postContent, String imageName, Date addDate,
            CategoryDto category, UserDto user) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.imageName = imageName;
        this.addDate = addDate;
        this.category = category;
        this.user = user;
    }

    public PostDto() {
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

}