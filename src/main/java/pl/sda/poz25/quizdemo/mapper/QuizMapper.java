package pl.sda.poz25.quizdemo.mapper;

import pl.sda.poz25.quizdemo.dto.QuizDto;
import pl.sda.poz25.quizdemo.entity.QuizEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class QuizMapper {

    public static QuizDto mapEntityToDto(QuizEntity entity) {

        QuizDto dto = new QuizDto();
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setCreateDate(new SimpleDateFormat("dd-MM-yyyy").format(entity.getCreateDate()));

        return dto;
    }

    public static List<QuizDto> mapEntityListToDtoList(Iterable<QuizEntity> entities) {

        List<QuizDto> dtos = new ArrayList<>();

        for (QuizEntity entity : entities) {
            dtos.add(mapEntityToDto(entity));
        }

        return dtos;
    }

    public static QuizEntity mapDtoToEntity(QuizDto dto) throws ParseException {

        QuizEntity entity = new QuizEntity();
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());

        if (dto.getCreateDate() != null) {
            entity.setCreateDate(new SimpleDateFormat("dd-MM-yyyy").parse(dto.getCreateDate()));
        }

        return entity;
    }
}
