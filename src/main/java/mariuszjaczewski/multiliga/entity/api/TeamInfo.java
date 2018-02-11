package mariuszjaczewski.multiliga.entity.api;

import mariuszjaczewski.multiliga.model.User;

import java.util.List;

public class TeamInfo {

    private Long id;
    private String name;
    private String captainName;
    private String type;


    public TeamInfo(Long id, String name, String captainName, String type ) {
        this.id = id;
        this.name = name;
        this.captainName = captainName;
        this.type = type;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
