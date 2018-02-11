package mariuszjaczewski.multiliga.entity.api;

public class InvitationInfo {
    private Long teamId;
    private String teamName;
    private String teamCaptainName;
    private String email;
    private String type;

    public InvitationInfo(Long teamId, String teamName, String teamCaptainName, String email,  String type) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamCaptainName = teamCaptainName;
        this.email = email;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCaptainName() {
        return teamCaptainName;
    }

    public void setTeamCaptainName(String teamCaptainName) {
        this.teamCaptainName = teamCaptainName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
