package com.istore.istoreproject.Services;

import com.istore.istoreproject.models.Question;

import java.util.List;

public interface QuestionService {

    Question addQuestion(Question question);

    Question updateQuestion(long id, Question question);

    void deleteQuestion(long id);

    Question getById(long id);

    List<Question> findAll();

    List<Question> findParents();

    List<Question> findQuestionsWithNoChildren();

    List<Question> findQuestionChildren(long id);
}
