package com.application.sport.repository;

import com.application.sport.model.SportEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportEventRepository extends JpaRepository<SportEvent, Long> {

}
