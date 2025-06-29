package com.bhargav.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bhargav.quizapp.Model.Question;
import com.bhargav.quizapp.Model.QuestionWrapper;
import com.bhargav.quizapp.Model.Quiz;
import com.bhargav.quizapp.Model.Response;
import com.bhargav.quizapp.dao.QuestionDao;
import com.bhargav.quizapp.dao.QuizDao;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {

        List<Question> questions = questionDao.findRandomQuestionByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Sucess",HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDb = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for(Question q: questionsFromDb){
            QuestionWrapper questionWrapper = new QuestionWrapper(q.getId(),q.getCategory(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getQuestionTitle());
            questionsForUser.add(questionWrapper);
        }
        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateResults(Integer id, List<Response> responces) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questions = quiz.get().getQuestions();
        int right = 0;
        int i = 0;
        for(Response response : responces){
           if(response.getResponse().equals(questions.get(i).getRightAnswer())){
            right++;
           }
           i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }


}
