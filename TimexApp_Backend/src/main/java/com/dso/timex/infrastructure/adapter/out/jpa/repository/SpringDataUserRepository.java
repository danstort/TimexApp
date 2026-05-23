package com.dso.timex.infrastructure.adapter.out.jpa.repository;

import com.dso.timex.infrastructure.adapter.out.jpa.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataUserRepository extends JpaRepository<UserJpaEntity, UUID> {
}
