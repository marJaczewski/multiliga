package mariuszjaczewski.multiliga.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "race")
public class Race {

    @Id
    @GeneratedValue
    @Column(name = "race_id")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "dyscypline")
    private Dyscypline dyscypline;

    @Column(name = "capacity")
    private Long capacity;

    @Column(name = "date")
    private String date;

    @Column(name = "distance")
    private int distance;

    @Column(name = "place")
    private String place;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "race_user", joinColumns = @JoinColumn(name = "race", referencedColumnName = "race_id"), inverseJoinColumns = @JoinColumn(name = "user", referencedColumnName = "id"))
    private List<User>users;



    public Race() {
    }



    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Race(Dyscypline dyscypline, Long capacity, String date, int distance, String place) {
         this.dyscypline = dyscypline;
        this.capacity = capacity;
        this.date = date;
        this.distance = distance;
        this.place = place;
    }

    public Race(Dyscypline dyscypline, Long capacity, String date, int distance, String place, List<User> users) {
        this.dyscypline = dyscypline;
        this.capacity = capacity;
        this.date = date;
        this.distance = distance;
        this.place = place;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dyscypline getDyscypline() {
        return dyscypline;
    }

    public void setDyscypline(Dyscypline dyscypline) {
        this.dyscypline = dyscypline;
    }

    public Long getcapacity() {
        return capacity;
    }

    public void setcapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}


