package pl.sda.poz25.quizdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.sda.poz25.quizdemo.entity.QuizEntity;
import pl.sda.poz25.quizdemo.entity.User;
import pl.sda.poz25.quizdemo.repository.QuizRepository;
import pl.sda.poz25.quizdemo.repository.UserRepository;

import java.util.Date;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user = new User();
        user.setUsername("test");
        user.setPassword(passwordEncoder.encode("test"));
        userRepository.save(user);

        QuizEntity entity = new QuizEntity();
        entity.setTitle("Pierwszy quiz");
        entity.setDescription("To jest opis pierwszego quizu");
        entity.setCreateDate(new Date());

        quizRepository.save(entity);
    }
}
