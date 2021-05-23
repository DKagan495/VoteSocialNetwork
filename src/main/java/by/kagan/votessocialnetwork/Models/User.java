package by.kagan.votessocialnetwork.Models;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.*;
import javax.persistence.*;
@Entity
@Table(name = "users")
public class User {
    @Id
    private int id = 0;
    @NotNull(message = "Enter age please")
    @Min(value = 16, message = "Our network only for 16+")
    @Max(value = 123, message = "You`re very old for this application")
    private int age;
    @Column(name = "numbervotes")
    private int numberOfVotes = 0;
    @Column(name = "name")
    @NotEmpty(message = "Enter name please")
    @Size(min = 2, max = 30, message = "Invalid name")
    private String name;
    @Column(name = "surname")
    @NotEmpty(message = "Enter surname please")
    @Size(min = 2, max = 30, message = "Invalid surname")
    private String surname;
    @Column(name="patronymic")
    @NotEmpty(message = "Enter patronymic please")
    @Size(min = 5, max = 36, message = "Invalid patronymic")
    private String patronymic;
    @Column(name = "university")
    @NotEmpty(message = "Enter a university please, this is not optional")
    private String university;
    @Column(name = "workplace")
    @NotEmpty(message = "Enter the workplace, please. This is not optional")
    private String workplace;
    @Column(name = "email")
    @NotEmpty(message = "Enter email please")
    @Email(message = "Email should be email. Not random stack of symbols")
    private String email;
    @Column(name = "password")
    @NotEmpty(message = "Password is very important thing, please create it!")
    @Size(min = 8, message = "Password must be contain >7 characters")
    private String password;
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
