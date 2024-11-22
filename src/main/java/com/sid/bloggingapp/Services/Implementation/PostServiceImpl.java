package com.sid.bloggingapp.Services.Implementation;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sid.bloggingapp.Entities.Category;
import com.sid.bloggingapp.Entities.PostEntitty;
import com.sid.bloggingapp.Entities.User;
import com.sid.bloggingapp.Exceptions.ResourceNotFoundException;
import com.sid.bloggingapp.Payloads.PostDto;
import com.sid.bloggingapp.Payloads.PostResponce;
import com.sid.bloggingapp.Repositiories.CategoryRepository;
import com.sid.bloggingapp.Repositiories.PostRepository;
import com.sid.bloggingapp.Repositiories.UserRepo;
import com.sid.bloggingapp.Services.PostService;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepository categoryRepository;

    // Create new
    // Post__________________________________________________________________________________________________

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));

        PostEntitty postEntitty = this.modelMapper.map(postDto, PostEntitty.class);
        postEntitty.setImageName("defult.png");
        postEntitty.setAddDate(new Date());
        postEntitty.setUser(user);
        postEntitty.setCategory(category);

        PostEntitty newpost = this.postRepository.save(postEntitty);

        return this.modelMapper.map(newpost, PostDto.class);

    }
    // Update
    // Post____________________________________________________________________________________________________

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        PostEntitty post = this.postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "Post id", postId));
        post.setPostTitle(postDto.getPostTitle());
        post.setPostContent(postDto.getPostContent());
        post.setImageName(postDto.getImageName());
        PostEntitty updatedPost = this.postRepository.save(post);
        return this.modelMapper.map(updatedPost, PostDto.class);

    }
    // Delete
    // POst__________________________________________________________________________________________________

    @Override
    public void deletePost(Integer postId) {
        PostEntitty post = this.postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "Post id", postId));
        this.postRepository.delete(post);

    }
    // Get Post By Post
    // Id________________________________________________________________________________________

    @Override
    public PostDto getPostById(Integer postId) {
        PostEntitty post = this.postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "Post id", postId));
        return this.modelMapper.map(post, PostDto.class);
    }
    // Get All
    // Post________________________________________________________________________________________________

    @Override
    public PostResponce getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        // Determine the sort direction
        Sort sort = sortDir.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // Create a pageable object with sorting
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        // Fetch paginated and sorted data from the repository
        Page<PostEntitty> pagePost = this.postRepository.findAll(pageable);
        List<PostEntitty> posts = pagePost.getContent();

        // Map entities to DTOs
        List<PostDto> postDtos = posts.stream()
                .map(post -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        // Build the response object
        PostResponce postResponce = new PostResponce();
        postResponce.setContent(postDtos);
        postResponce.setTotalPages(pagePost.getTotalPages());
        postResponce.setPageNumber(pagePost.getNumber());
        postResponce.setPageSize(pagePost.getSize());
        postResponce.setTotalElements(pagePost.getTotalElements());
        postResponce.setLastPageNumber(pagePost.isLast());
        postResponce.setNextPageNumber(pagePost.isLast() ? null : pageNumber + 1);

        return postResponce;
    }

    // Get Post By Category
    // Id____________________________________________________________________________________

    @Override
    public PostResponce getPostsByCategory(Integer categoryId, Integer pageNumber, Integer pageSize) {
        // Find the category
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id ", categoryId));
        // Create Pageable instance
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        // Get paginated posts
        Page<PostEntitty> pagePosts = this.postRepository.findByCategory(category, pageable);
        List<PostDto> postDtos = pagePosts.stream()
                .map(post -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
        // Create response object
        PostResponce postResponce = new PostResponce();
        postResponce.setContent(postDtos);
        postResponce.setTotalPages(pagePosts.getTotalPages());
        postResponce.setPageNumber(pagePosts.getNumber());
        postResponce.setPageSize(pagePosts.getSize());
        postResponce.setTotalElements(pagePosts.getTotalElements());
        postResponce.setLastPageNumber(pagePosts.isLast());

        return postResponce;
    }
    // Get all Post By User
    // ID____________________________________________________________________________________

    @Override
    public PostResponce getPostsByUser(Integer userId, Integer pageNumber, Integer pageSize) {
        // Find user
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));

        // Create Pageable instance
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        // Get paginated posts
        Page<PostEntitty> pagePosts = this.postRepository.findByUser(user, pageable);

        // Convert entities to DTOs
        List<PostDto> postDtos = pagePosts.getContent().stream()
                .map(post -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        // Create response object
        PostResponce postResponce = new PostResponce();
        postResponce.setContent(postDtos);
        postResponce.setTotalPages(pagePosts.getTotalPages());
        postResponce.setPageNumber(pagePosts.getNumber());
        postResponce.setPageSize(pagePosts.getSize());
        postResponce.setTotalElements(pagePosts.getTotalElements());
        postResponce.setLastPageNumber(pagePosts.isLast());

        return postResponce;
    }

    // Search post_________________________________________________________

    @Override
    public PostResponce searchPost(String keyword, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        // Fetch posts by keyword with pagination
        Page<PostEntitty> pagePosts = this.postRepository
                .findByPostTitleContainingIgnoreCaseOrPostContentContainingIgnoreCase(keyword, keyword, pageable);

        // Convert entities to DTOs
        List<PostDto> postDtos = pagePosts.getContent().stream()
                .map(post -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        // Build the response
        PostResponce postResponce = new PostResponce();
        postResponce.setContent(postDtos);
        postResponce.setTotalPages(pagePosts.getTotalPages());
        postResponce.setPageNumber(pagePosts.getNumber());
        postResponce.setPageSize(pagePosts.getSize());
        postResponce.setTotalElements(pagePosts.getTotalElements());
        postResponce.setLastPageNumber(pagePosts.isLast());

        return postResponce;
    }

}
