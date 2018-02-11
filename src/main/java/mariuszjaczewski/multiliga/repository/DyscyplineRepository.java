package mariuszjaczewski.multiliga.repository;

import mariuszjaczewski.multiliga.model.Dyscypline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DyscyplineRepository extends JpaRepository<Dyscypline, Long> {

    Dyscypline getOneByName(String name);
    Dyscypline getOneByDyscyplineId(Long disciplineId);


}
