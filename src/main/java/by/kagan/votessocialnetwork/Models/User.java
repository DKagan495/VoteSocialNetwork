package by.kagan.votessocialnetwork.Models;

import javax.validation.constraints.Min;

public class User {
    private int id = 0;
    @Min(0)
    private int age;
    private int numberOfVotes = 0;
    private String name, surname, patronymic, university, workplace, email, password;
    private boolean logInSuccessful = false;
    public User() {

    }
    public User(String name, String surname, String patronymic, int age, String university, String workplace, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.university = university;
        this.workplace = workplace;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogInSuccessful() {
        return logInSuccessful;
    }

    public void setLogInSuccessful(boolean logInSuccessful) {
        this.logInSuccessful = logInSuccessful;
    }
}
