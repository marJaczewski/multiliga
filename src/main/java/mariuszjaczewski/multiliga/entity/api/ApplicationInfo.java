package mariuszjaczewski.multiliga.entity.api;

public class ApplicationInfo {
    private String userName;
    private Long applicationId;
    private String date;
    private String wiek;
    private String email;


    public ApplicationInfo(String userName, Long applicationId, String date, String wiek, String email) {
        this.userName = userName;
        this.applicationId = applicationId;
        this.date = date;
        this.wiek = wiek;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return applicationId;
    }

    public void setUserId(Long userId) {
        this.applicationId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWiek() {
        return wiek;
    }

    public void setWiek(String wiek) {
        this.wiek = wiek;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
