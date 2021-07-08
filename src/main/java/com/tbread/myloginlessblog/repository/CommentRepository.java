package com.tbread.myloginlessblog.repository;

import com.tbread.myloginlessblog.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "SELECT * FROM comment WHERE board_id = :board_id order by created_at desc",nativeQuery = true)
    List<Comment> findByBoardIdOrderByCreatedAtDesc(@Param(value="board_id")Long board_id);
}
