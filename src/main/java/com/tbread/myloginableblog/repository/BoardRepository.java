package com.tbread.myloginableblog.repository;

import com.tbread.myloginableblog.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
    List<Board> findAllByOrderByCreatedAtDesc();
}
