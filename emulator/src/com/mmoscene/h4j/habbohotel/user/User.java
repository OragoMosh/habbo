package com.mmoscene.h4j.habbohotel.user;

public class User {
    private int id;
    private int credits;
    private int pixels;
    private int currency;
    private int rank;
    private int respect;
    private int daily_respect;
    private int home;
    private int name_changes;
    private int primary_guild;

    private String username;
    private String email;
    private String motto;
    private String look;
    private String client_key;
    private String last_active;

    private char gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getPixels() {
        return pixels;
    }

    public void setPixels(int pixels) {
        this.pixels = pixels;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRespect() {
        return respect;
    }

    public void setRespect(int respect) {
        this.respect = respect;
    }

    public int getDailyRespect() {
        return daily_respect;
    }

    public void setDailyRespect(int daily_respect) {
        this.daily_respect = daily_respect;
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public int getNameChanges() {
        return name_changes;
    }

    public void setNameChanges(int name_changes) {
        this.name_changes = name_changes;
    }

    public int getPrimaryGuild() {
        return primary_guild;
    }

    public void setPrimaryGuild(int primary_guild) {
        this.primary_guild = primary_guild;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }

    public String getClientKey() {
        return client_key;
    }

    public void setClientKey(String client_key) {
        this.client_key = client_key;
    }

    public String getLastActive() {
        return last_active;
    }

    public void setLastActive(String last_active) {
        this.last_active = last_active;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void append() {

    }
}
