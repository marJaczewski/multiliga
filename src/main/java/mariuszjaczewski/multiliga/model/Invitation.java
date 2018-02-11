package mariuszjaczewski.multiliga.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table(name = "invitaion")
@Entity
public class Invitation {

    @Id
    @GeneratedValue
    @Column(name = "invitaion_id")
    private Long invitation_id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="team_id")
    private Team team;

    @Column(name = "date")
    private String date;

    public Invitation(User user, Team team, String date) {
        this.user = user;
        this.team = team;
        this.date = date;
    }

    public Invitation() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
