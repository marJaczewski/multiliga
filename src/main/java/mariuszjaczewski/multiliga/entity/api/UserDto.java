package mariuszjaczewski.multiliga.entity.api;

import mariuszjaczewski.multiliga.model.Team;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class UserDto {



    private String nazwisko;

    private String email;

    private String haslo;

    public UserDto(String nazwisko, String email, String haslo) {
        this.nazwisko = nazwisko;
        this.email = email;
        this.haslo = haslo;
    }

    public UserDto() {
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "nazwisko='" + nazwisko + '\'' +
                ", email='" + email + '\'' +
                ", haslo='" + haslo + '\'' +
                '}';
    }
}
