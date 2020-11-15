package pl.sda.poz25.quizdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.poz25.quizdemo.entity.QuizEntity;

@Repository
public interface QuizRepository extends CrudRepository<QuizEntity, Long> {

    QuizEntity getById(Long id);
}
