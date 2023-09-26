package com.system.appointment2.repo;

import com.system.appointment2.model.LessPerformanceNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface LessPerformanceNoteRepo extends JpaRepository<LessPerformanceNote,Integer> {
}
