package pl.sda.poz25.quizdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sda.poz25.quizdemo.dto.QuizDto;
import pl.sda.poz25.quizdemo.service.QuizService;

import java.awt.desktop.QuitStrategy;
import java.util.List;

@Controller
public class QuizController {

    @Autowired
    private QuizService quizService;

    @RequestMapping(value = "/quiz", method = RequestMethod.GET)
    public String quizList(Model model) {

        List<QuizDto> dtos = quizService.getAll();

        model.addAttribute("quizList", dtos);

        return "quizList";
    }

    @RequestMapping(value = "/quiz/add", method = RequestMethod.GET)
    public String quizCreate(Model model) {

        QuizDto quiz = new QuizDto();

        model.addAttribute("quiz", quiz);

        return "quizCreate";
    }

    @RequestMapping(value = "/quiz/add", method = RequestMethod.POST)
    public String quizCreate(@ModelAttribute("quiz") QuizDto quizDto) {

        quizService.createQuiz(quizDto);

        return "redirect:/quiz";
    }
}
