package com.comcast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comcast.model.Cells;

@Repository
public interface CellRepository extends JpaRepository<Cells, Integer> {

}
