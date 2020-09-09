package com.swann.reactandspring.repository.content;

import com.swann.reactandspring.entity.UserPost.UserContent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserContentRepository extends CrudRepository<UserContent, Long> {

}
