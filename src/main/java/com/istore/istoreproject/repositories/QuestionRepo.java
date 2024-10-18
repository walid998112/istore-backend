package com.istore.istoreproject.repositories;

import java.util.Optional;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.istore.istoreproject.models.Question;

public interface QuestionRepo extends JpaRepository<Question, Long> {

    Optional<Question> findByQuestionText(String quest);

    @Query("select q from Question q where q.parentQuestion.question_id = ?1")
    List<Question> findQuestionChildren(long id);

}
