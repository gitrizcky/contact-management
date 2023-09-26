package io.rizcky.contact.management.repository;

import io.rizcky.contact.management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
