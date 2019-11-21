package edu.mum.mail.config;

public class AppConfig {
    private String DBUrl;
    private String DBUsername;
    private String DBPwd;

    public AppConfig() {
    }

    public AppConfig(String DBUrl, String DBUsername, String DBPwd) {
        this.DBUrl = DBUrl;
        this.DBUsername = DBUsername;
        this.DBPwd = DBPwd;
    }

    public String getDBUrl() {
        return DBUrl;
    }

    public void setDBUrl(String DBUrl) {
        this.DBUrl = DBUrl;
    }

    public String getDBUsername() {
        return DBUsername;
    }

    public void setDBUsername(String DBUsername) {
        this.DBUsername = DBUsername;
    }

    public String getDBPwd() {
        return DBPwd;
    }

    public void setDBPwd(String DBPwd) {
        this.DBPwd = DBPwd;
    }
}
