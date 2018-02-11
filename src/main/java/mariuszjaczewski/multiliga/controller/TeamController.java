package mariuszjaczewski.multiliga.controller;


import mariuszjaczewski.multiliga.entity.api.ApplicationInfo;
import mariuszjaczewski.multiliga.entity.api.InvitationInfo;
import mariuszjaczewski.multiliga.entity.api.TeamDto;
import mariuszjaczewski.multiliga.entity.api.TeamInfo;
import mariuszjaczewski.multiliga.model.*;
import mariuszjaczewski.multiliga.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/team")


public class TeamController {

     @Autowired
    private final TeamRepository teamRepository;
     @Autowired
    private final DyscyplineRepository dyscyplineRepository;
     @Autowired
    private final UserRepository userRepository;
     @Autowired
     private final ApplicationRepository applicationRepository;
     @Autowired
     private final InvitationRepository invitationRepository;


    public TeamController(
            TeamRepository teamRepository,
            DyscyplineRepository dyscyplineRepository,
            UserRepository userRepository,
            ApplicationRepository applicationRepository,
            InvitationRepository invitationRepository){
        this.teamRepository = teamRepository;
        this.dyscyplineRepository = dyscyplineRepository;
        this.userRepository = userRepository;
        this.applicationRepository = applicationRepository;
        this.invitationRepository = invitationRepository;
    }

    @RequestMapping(value = "/createNewTeam/{name}/{captainId}/{type}", method = RequestMethod.GET)
    public List<String> createNewTeam(
            @PathVariable("name") String name,
            @PathVariable("captainId") Long captainId,
            @PathVariable("type") String type) {
        List<String> message = new ArrayList<>();
        TeamDto teamDto = new TeamDto(name, captainId, type);


        System.err.println("Odebrano nową drużynę: " + teamDto.toString());

//sprawdzenie czy user zakładający team, ma już nalezy już do jakiejś drużyny
//czyli, czy team_id == null
        User user = userRepository.getOneById(teamDto.getCaptainId());

        if (user.getTeam() == null) {
            System.err.println("User nie ma druzyny");


            //pobranie dyscypliny
            Dyscypline dyscypline = dyscyplineRepository.getOneByName(teamDto.getType());

            //pobranie kapitana drużyny
            List<User> users = new ArrayList<User>();
            users.add(user);
            //sprawdzenie czy nazwa druzuny jeest wolna

            if (teamRepository.findAllByName(teamDto.getName()).size() == 0) {

                Team team = new Team(teamDto.getName(), teamDto.getCaptainId(), users, dyscypline);

                //setowanie pola team w userze

                teamRepository.save(team);
                userRepository.setUserTeamById(team, teamDto.getCaptainId());
                userRepository.setUserToCaptainById(teamDto.getCaptainId());
                message.add("Dodano drużynę! Jesteś jej kapitanem.");
                return message;


            } else {
                message.add("Podana nazwa drużyny jest już zajęta. Podaj inną nazwe.");
                return message;
            }
        } else {
            message.add("Nie możesz założyć nowej drużyny, ponieważ już masz drużynę.");
            return message;
        }
    }


    @RequestMapping(value = "/getAllTeams", method = RequestMethod.GET)
    public List<TeamInfo> getAllTeams(){

         List<Team> allTeams = teamRepository.findAll();
         List<TeamInfo> allTeamsInfo=new ArrayList<>();

         for(int i=0 ; i<allTeams.size() ; i++){
             String captainName = userRepository.getOneById(allTeams.get(i).getCaptainUserId()).getNazwisko();
             String type = allTeams.get(i).getDyscypline().getName();

             TeamInfo teamInfoTemp = new TeamInfo(allTeams.get(i).getTeamId(), allTeams.get(i).getName(), captainName, type);

             allTeamsInfo.add(teamInfoTemp);

         }

         return allTeamsInfo;
    }


    @RequestMapping(value = "/applyToTeam/{userId}/{teamId}", method = RequestMethod.GET)
    public List<String>applyToTeam(
            @PathVariable("userId") Long userId,
            @PathVariable("teamId") Long teamId  ) {

        List<String>message = new ArrayList<>();

        if(userRepository.getOneById(userId).getTeam()!=null){
            System.err.println("User, ma już drużynę");
            message.add("Nie możesz wysłać zgłoszenia do drużyny, bo już posiadasz drużynę!");
            return message;
        }else{
            //wyciąganie danych potrzebnych do stworzenia zgłoszenia do drużyny



            User user = userRepository.getOneById(userId);
            Team team = teamRepository.getOneByTeamId(teamId);

            String timeStamp = new SimpleDateFormat("HH:mm:ss, dd.MM.yyyy").format(new Date());


//            Application application = new Application(1L, user, team, timeStamp);
            Application application = new Application(  timeStamp, team, user);

            System.err.println("Dodano zgłoszenie: "+application.toString());
            applicationRepository.save(application);

            message.add("Zgłoszenie zostało wysłane");
            return  message;

        }
    }

        @RequestMapping(value = "/getMembers/{teamId}", method = RequestMethod.GET)
    public List<User> getTeamMembers(@PathVariable("teamId")Long teamId){
            System.err.println("Pobrano zawodników");
            //List<User> teamMembers=new ArrayList<>();

        return userRepository.getAllByTeam(teamId);

        }

        @RequestMapping(value = "/showApplications/{userId}", method = RequestMethod.GET)
    public  List<ApplicationInfo>getAllApplicationsToMyTeam(@PathVariable("userId")Long userId){


            //znalezienie, której drużuny kapitanem jest user z userId
       // Team team = teamRepository.getOneByCaptainUserId(userId);
            Team team = teamRepository.getFirstByCaptainUserId(userId);

            List<ApplicationInfo> applicationInfos = new ArrayList<>();

            List<Application> applications= applicationRepository.findAllByTeamTeamId(team.getTeamId());
           for(int i =0 ; i<applications.size(); i++){
              User user= userRepository.getOneById(applications.get(i).getUser().getId());

               ApplicationInfo applicationInfo = new ApplicationInfo(
                      user.getNazwisko(),
                       applications.get(i).getApplication_id(),
                       applications.get(i).getDate(),
                       "brak danych",
                       user.getEmail());

               applicationInfos.add(applicationInfo);

           }

        return  applicationInfos;


        }


    @RequestMapping(value = "/acceptApplication/{applicationId}", method = RequestMethod.GET)
    public  List<String> acceptApplication (@PathVariable("applicationId")Long applicationId){

        //pobranie zgłoszenia, które ma zostać zaakceptowane
        Application application = applicationRepository.getOne(applicationId);

        //updatowanie pola team_id usera
        userRepository.setUserTeamById(application.getTeam(),application.getUser().getId());

        //usunięcie zgłoszenia
        applicationRepository.delete(applicationId);


List<String>message = new ArrayList<>();
message.add("Zaakceptowałeś zgłoszenie");
        return  message ;


    }


    @RequestMapping(value = "/deleteMember/{userId}")
    public List<String> deleteMemberFromTeam(@PathVariable("userId")Long userId){

userRepository.setUserTeamById(null, userId);

List<String> message = new ArrayList<>();

message.add("Usunięto drużyny.");

return message;
    }


    @RequestMapping( value = "/getAllUsersWithoutTeam", method = RequestMethod.GET)
    public List<Object> getAllUsersWithoutTeam(){

        List<Object>usersWithoutTeam = userRepository.getAllUsersWithoutTeam();

        return usersWithoutTeam;

    }

    @RequestMapping(value = "/sendInvitation/{userToInvite}/{captainId}", method = RequestMethod.GET)
    public List<String> inviteUser (@PathVariable("userToInvite")Long userToInvite, @PathVariable("captainId") Long captainId ){
        List<String> message = new ArrayList<>();
        //znaleznienie, która drużyna zaprasza na podstawie id jej kapitana

        Team team =teamRepository.getFirstByCaptainUserId(captainId);

        //znalezienie zapraszanego usera
        User user =userRepository.getOneById(userToInvite);

        String timeStamp = new SimpleDateFormat("HH:mm:ss-dd.MM.yyyy").format(new Date());

        invitationRepository.save( new Invitation(user, team, timeStamp));

        message.add("Zaprosznie wysłano");
        return  message;
    }


@RequestMapping(value = "/getMyTeam/{userId}", method = RequestMethod.GET)
    public List<Object> getTeamDetails (@PathVariable("userId")Long userId){
List<Object> message = new ArrayList<>();
User user = userRepository.getOneById(userId);

if(user.getTeam()==null){
     message.add("Zawodnik nie ma drużyny");


return message;
}else {

    Team team = teamRepository.getOneByTeamId(user.getTeam().getTeamId());
message.add( new TeamInfo(team.getTeamId(), team.getName(), userRepository.getOneById(team.getCaptainUserId()).getNazwisko(), team.getDyscypline().getName() ));
     return   message;

}}

@RequestMapping(value = "/getMyInvitations/{userId}", method = RequestMethod.GET)
        public List<InvitationInfo> getUsersInvitations(@PathVariable("userId")Long userId){
//używam klasy ApplicationInfo bo też pasuje
        List<InvitationInfo> invitationsInfo = new ArrayList<>();

        List<Invitation>invitations = invitationRepository.findAllByUserId(userId);

        for(int i=0 ; i<invitations.size() ; i++) {
           InvitationInfo invitation = new InvitationInfo(
                invitations.get(i).getTeam().getTeamId(),
                   invitations.get(i).getTeam().getName(),
                   invitations.get(i).getUser().getNazwisko(),
                   invitations.get(i).getUser().getEmail(),
                   invitations.get(i).getTeam().getDyscypline().getName()
                   );

           invitationsInfo.add(invitation);
        }
return invitationsInfo;
}

@RequestMapping(value = "/acceptInvitation/{userId}/{teamId}")
    public List<String> acceptInvitation(@PathVariable("userId")Long userId, @PathVariable("teamId")Long teamId){
         List<String>message = new ArrayList<>();
         User user = userRepository.getOneById(userId);


            if(user.getTeam()!=null){
                message.add("Nie możesz zaakceptować zaproszenia do drużyny, bo już jestes w drużynie." +
                        " Najpierw wyjdź z drużyny, w której jesteś obecnie, a potem zaakceptuj zaproszenie.");
                return message;
            }else{
                userRepository.setUserTeamById(teamRepository.getOneByTeamId(teamId), userId);
                invitationRepository.deleteInvtationByUserIdAndTeamId(teamId, userId);

                message.add("Zostałeś dodany do nowej drużyny.");
                return message;

            }


}










}
