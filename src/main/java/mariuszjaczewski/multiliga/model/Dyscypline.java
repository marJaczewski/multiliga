package mariuszjaczewski.multiliga.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dyscipline")
public class Dyscypline {

    @Id
    @GeneratedValue
    @Column(name = "dysciplineId")
    private Long dyscyplineId;

    @Column(name = "name")
    private String name;

    @Column(name = "dyscyplines")
    @OneToMany(mappedBy = "dyscypline", cascade = CascadeType.ALL)
    private List<Team>teams;

    @Column(name = "races")
    @OneToMany(mappedBy = "dyscypline", cascade = CascadeType.ALL)
    private List<Race>races;

    public Dyscypline(String name, List<Team> teams) {
        this.name = name;
        this.teams = teams;
    }

    public Dyscypline() {
    }

    public Long getDyscyplineId() {
        return dyscyplineId;
    }

    public void setDyscyplineId(Long dyscyplineId) {
        this.dyscyplineId = dyscyplineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }
}
