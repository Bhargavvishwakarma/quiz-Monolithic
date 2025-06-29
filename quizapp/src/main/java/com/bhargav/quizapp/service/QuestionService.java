package com.bhargav.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bhargav.quizapp.Model.Question;
import com.bhargav.quizapp.dao.QuestionDao;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestion() {
        try {
             return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
        } catch (Exception e) {
             return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }
       
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
       try {
         return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
       } catch (Exception e) {
         return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
       }
    }

    public ResponseEntity<String> addQuestion(Question question) {
       
        try {
             questionDao.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Exception while adding question",HttpStatus.BAD_REQUEST);
        }
    }
    
}
