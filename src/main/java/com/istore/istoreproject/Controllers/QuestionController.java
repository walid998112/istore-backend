package com.istore.istoreproject.Controllers;

import com.istore.istoreproject.Services.QuestionService;
import com.istore.istoreproject.models.Question;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/add")
    public ResponseEntity<?> addQuestion(@RequestBody Question question) {
        try {
            Question addedQuestion = questionService.addQuestion(question);
            return ResponseEntity.ok(addedQuestion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add question: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateQuestion(@PathVariable long id, @RequestBody Question question) {
        try {
            Question updatedQuestion = questionService.updateQuestion(id, question);
            return ResponseEntity.ok(updatedQuestion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update question: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable long id) {
        try {
            questionService.deleteQuestion(id);
            return ResponseEntity.ok(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete question: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuestionById(@PathVariable long id) {
        try {
            Question question = questionService.getById(id);
            return ResponseEntity.ok(question);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to get question: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionService.findAll();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/parents")
    public ResponseEntity<List<Question>> getAllParents() {
        List<Question> questions = questionService.findParents();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/no-children")
    public ResponseEntity<List<Question>> getQuestionsWithNoChildren() {
        List<Question> questions = questionService.findQuestionsWithNoChildren();
        return ResponseEntity.ok(questions);
    }
    @GetMapping("/children/{id}")
    public ResponseEntity<List<Question>> findQuestionChildren(@PathVariable long id) {
        List<Question> questions = questionService.findQuestionChildren(id);
        return ResponseEntity.ok(questions);
    }
}
