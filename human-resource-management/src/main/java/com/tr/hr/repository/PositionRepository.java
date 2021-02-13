package com.tr.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tr.hr.entity.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {

}
