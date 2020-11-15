package pl.sda.poz25.quizdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.sda.poz25.quizdemo.entity.QuizEntity;
import pl.sda.poz25.quizdemo.repository.QuizRepository;

import java.util.Date;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        QuizEntity entity = new QuizEntity();
        entity.setTitle("Pierwszy quiz");
        entity.setDescription("To jest opis pierwszego quizu");
        entity.setCreateDate(new Date());

        quizRepository.save(entity);
    }
}
