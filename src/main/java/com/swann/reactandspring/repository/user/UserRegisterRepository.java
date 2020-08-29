package com.swann.reactandspring.repository.user;

import com.swann.reactandspring.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegisterRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);

    User findByUsername(String username);

    User getById(Long id);
}
