package com.bhargav.quizapp.dao;

import org.springframework.stereotype.Repository;


import com.bhargav.quizapp.Model.Quiz;



import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

    

}