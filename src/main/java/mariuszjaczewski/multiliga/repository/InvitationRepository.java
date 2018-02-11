package mariuszjaczewski.multiliga.repository;

import mariuszjaczewski.multiliga.model.Invitation;
import mariuszjaczewski.multiliga.model.Team;
import mariuszjaczewski.multiliga.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {

    List<Invitation> findAllByUserId(Long userId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM invitaion where user_id = :#{#userId} and team_id = :#{#teamId}", nativeQuery = true)
    void deleteInvtationByUserIdAndTeamId(@Param("teamId")Long teamId, @Param("userId") Long userId);

}
