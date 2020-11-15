package pl.sda.poz25.quizdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.poz25.quizdemo.dto.QuizDto;
import pl.sda.poz25.quizdemo.entity.QuizEntity;
import pl.sda.poz25.quizdemo.mapper.QuizMapper;
import pl.sda.poz25.quizdemo.repository.QuizRepository;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public List<QuizDto> getAll() {

        Iterable<QuizEntity> entities = quizRepository.findAll();
        List<QuizDto> dtos = QuizMapper.mapEntityListToDtoList(entities);

        return dtos;
    }

    public QuizDto createQuiz(QuizDto dto) {

        try {
            QuizEntity entity = QuizMapper.mapDtoToEntity(dto);
            entity.setCreateDate(new Date());

            entity = quizRepository.save(entity);

            return QuizMapper.mapEntityToDto(entity);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public QuizDto getById(Long id) {
        QuizEntity entity = quizRepository.getById(id);
        return QuizMapper.mapEntityToDto(entity);
    }

    public List<QuizDto> searchQuizByName(String quizName) {

        // TODO: dodać odpowiednią logikę
        Iterable<QuizEntity> entities = quizRepository.findAll();
        List<QuizDto> dtos = QuizMapper.mapEntityListToDtoList(entities);

        return dtos;
    }
}
