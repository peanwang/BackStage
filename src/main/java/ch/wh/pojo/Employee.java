package ch.wh.pojo;

import java.util.Date;

public class Employee {
    private Integer id;
    private String name;
    private String Position;
    private String Office;
    private Integer Age;
    private String Date;
    private Integer Salary;

    public Employee() {
    }

    public Employee(Integer id, String name, String position, String office, Integer age, String date, Integer salary) {
        this.id = id;
        this.name = name;
        Position = position;
        Office = office;
        Age = age;
        Date = date;
        Salary = salary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getOffice() {
        return Office;
    }

    public void setOffice(String office) {
        Office = office;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Integer getSalary() {
        return Salary;
    }

    public void setSalary(Integer salary) {
        Salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
