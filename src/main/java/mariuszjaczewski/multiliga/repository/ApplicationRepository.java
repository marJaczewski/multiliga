package mariuszjaczewski.multiliga.repository;

import mariuszjaczewski.multiliga.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long>{



    @Query(value = "select  * from application where team_id = :#{#team_id}", nativeQuery = true)
    List<Application> getAllByTeamId(@Param("team_id") Long team_id);

    List<Application> findAllByTeamTeamId(Long team_id);


}
