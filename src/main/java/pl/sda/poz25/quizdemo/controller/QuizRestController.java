package pl.sda.poz25.quizdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.poz25.quizdemo.dto.QuizDto;
import pl.sda.poz25.quizdemo.service.QuizService;

import java.util.List;

@RestController
public class QuizRestController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/api/quiz")
    public List<QuizDto> quizList() {
        return quizService.getAll();
    }

    @GetMapping("/api/quiz/{id}")
    public QuizDto getQuiz(@PathVariable Long id) {
        return quizService.getById(id);
    }

    @PostMapping("/api/quiz")
    public QuizDto createQuiz(@RequestBody QuizDto quizDto) {
        return quizService.createQuiz(quizDto);
    }
}
