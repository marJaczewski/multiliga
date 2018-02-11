package mariuszjaczewski.multiliga.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue
    @Column(name = "application_id")
    private Long application_id;

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




    public Application(String date, Team team, User user) {
        this.user = user;
        this.team = team;
        this.date = date;
    }



    public Application() {
    }

    public Long getApplication_id() {
        return application_id;
    }

    public void setApplication_id(Long application_id) {
        this.application_id = application_id;
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

    @Override
    public String toString() {
        return "Application{" +
                "application_id=" + application_id +
                ", user=" + user +
                ", team=" + team +
                ", date='" + date + '\'' +
                '}';
    }
}
