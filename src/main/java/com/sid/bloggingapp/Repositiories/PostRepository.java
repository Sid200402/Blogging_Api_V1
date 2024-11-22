package com.sid.bloggingapp.Repositiories;

import com.sid.bloggingapp.Entities.Category;
import com.sid.bloggingapp.Entities.PostEntitty;
import com.sid.bloggingapp.Entities.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntitty, Integer> {
    Page<PostEntitty> findByCategory(Category category, Pageable pageable);

    Page<PostEntitty> findByUser(User user, Pageable pageable);

    Page<PostEntitty> findByPostTitleContainingIgnoreCaseOrPostContentContainingIgnoreCase(String titleKeyword,
            String contentKeyword, Pageable pageable);

}
