package com.jhennis.store.repo;

import com.jhennis.store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepo extends JpaRepository<User, Long>
{
}
