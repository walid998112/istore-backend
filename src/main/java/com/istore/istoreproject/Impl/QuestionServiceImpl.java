package com.istore.istoreproject.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.istore.istoreproject.Services.QuestionService;
import com.istore.istoreproject.models.Question;
import com.istore.istoreproject.repositories.QuestionRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepo questionRepo;

    @SuppressWarnings("null")
    @Override
    public Question addQuestion(Question question) {
        return questionRepo.save(question);

    }

    @Override
    public Question updateQuestion(long id, Question question) {
        Question question2 = questionRepo.findById(id).orElseThrow();
        question2.setQuestionText(question.getQuestionText());
        return questionRepo.save(question2);
    }

    @Override
    public void deleteQuestion(long id) {
        questionRepo.deleteById(id);
    }

    @Override
    public Question getById(long id) {
        return questionRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Question> findAll() {
        return this.questionRepo.findAll();
    }

    @Override
    public List<Question> findQuestionsWithNoChildren() {
        return questionRepo.findAll().stream()
                .filter(quest -> questionRepo.findQuestionChildren(quest.getQuestion_id()).isEmpty()).toList();
    }

    @Override
    public List<Question> findQuestionChildren(long id) {
        return questionRepo.findQuestionChildren(id);
    }

    @Override
    public List<Question> findParents() {
        return questionRepo.findAll().stream().filter(quest -> quest.getParentQuestion() == null).toList();

    }

}
