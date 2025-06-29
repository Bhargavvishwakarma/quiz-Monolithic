package com.bhargav.quizapp.dao;

import org.springframework.stereotype.Repository;
import com.bhargav.quizapp.Model.Question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
	List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(
        @Param("category") String category,
        @Param("numQ") int numQ
    );
}
