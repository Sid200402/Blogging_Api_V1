package com.sid.bloggingapp.Payloads;

public class CategoryDto {

    private Integer categoryId;
    private String categoryTitle;
    private String categoryDescription;

    public CategoryDto(Integer categoryId, String categoryTitle, String categoryDescription) {
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.categoryDescription = categoryDescription;
    }

    public CategoryDto() {
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

}
