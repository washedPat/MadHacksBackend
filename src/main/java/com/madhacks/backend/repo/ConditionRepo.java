package com.madhacks.backend.repo;

import com.madhacks.backend.model.Condition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConditionRepo extends JpaRepository<Condition, String> {
}
