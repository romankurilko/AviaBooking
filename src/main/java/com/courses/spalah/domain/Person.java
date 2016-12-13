package com.courses.spalah.domain;

import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
/*import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;*/

/**
 * Created by Roman on 17.11.2016.
 */
@Entity(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
//    @NotNull(message="Имя должно быть задано")
//    @Size(min = 3, message="Длина имени должна быть больше трех")
    private String firstName;

    @Column(name = "last_name")
//    @NotNull(message="Фамилия должна быть задана")
//    @Size(min = 3, message="Длина фамилии должна быть больше трех")
    private String lastName;

    @Column(name = "age")
//    @Min(value=0, message="Возраст больше нуля")
//    @NotNull(message="Возраст должен быть задан")
    private int age;

    @Column(name = "passport")
//    @Size(min=8, max=8, message="Не правильный формат паспортных данных")
//    @NotNull(message="Паспортные данные должены быть указаны")
    private String passport;

    @Column(name = "email")
//    @NotNull(message="Имэйл должен быть задан")
//    @Pattern(regexp = "^(?:[a-zA-Z0-9_'^&/+-])+(?:\\.(?:[a-zA-Z0-9_'^&/+-])+)" +
//            "*@(?:(?:\\[?(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))\\.)" +
//            "{3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\]?)|(?:[a-zA-Z0-9-]+\\.)" +
//            "+(?:[a-zA-Z]){2,}\\.?)$",
//            message = "заданный имэйл не может существовать")
    private String email;

    public Person() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(firstName, person.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", first_name='").append(firstName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
