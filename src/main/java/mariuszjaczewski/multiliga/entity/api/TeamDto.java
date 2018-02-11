package mariuszjaczewski.multiliga.entity.api;

import mariuszjaczewski.multiliga.model.Dyscypline;

public class TeamDto {

    private String name;

    private Long captainId;

    private String type;


    public TeamDto() {
    }

    public TeamDto(String name, Long captainId, String type) {
        this.name = name;
        this.captainId = captainId;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCaptainId() {
        return captainId;
    }

    public void setCaptainId(Long captainId) {
        this.captainId = captainId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "TeamDto{" +
                "name='" + name + '\'' +
                ", captainId='" + captainId + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

