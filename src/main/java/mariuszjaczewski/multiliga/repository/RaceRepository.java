package mariuszjaczewski.multiliga.repository;

import mariuszjaczewski.multiliga.model.Race;
import mariuszjaczewski.multiliga.model.Team;
import mariuszjaczewski.multiliga.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RaceRepository extends JpaRepository<Race, Long> {


    @Modifying
    @Transactional
    @Query(value = "insert into race_user(race, user)  values ( :raceId, :userId)", nativeQuery = true)
    void setRaceMember(@Param("userId")Long userId, @Param("raceId") Long raceId);



}
