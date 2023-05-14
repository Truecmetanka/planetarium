package ru.coursework.Planetarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.coursework.Planetarium.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
