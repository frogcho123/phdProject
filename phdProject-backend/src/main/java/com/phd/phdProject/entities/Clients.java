package com.phd.phdProject.entities;


import javax.persistence.*;

@Entity
@Table(name="clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "egn")
    private Long egn;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "nick_name")
    private String nickName;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="clients_name")
    joinColumns= @JoinColumn(name = "clients_id"),
    inverseJoinColumns=@JoinColumn(name=city_id))


    @ManyToOne()
    @JoinColumn(name = "sex_id")
    private Sex sex;

    @Column(name = "current_account")
    private Double current;

    @Column(name = "saving_account")
    private Double saving;

    @Column(name = "credit_account")
    private Double credit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getEgn() {
        return egn;
    }

    public void setEgn(Long egn) {
        this.egn = egn;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Double getCurrent() {
        return current;
    }

    public void setCurrent(Double current) {
        this.current = current;
    }

    public Double getSaving() {
        return saving;
    }

    public void setSaving(Double saving) {
        this.saving = saving;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Clients(){ }

    public Clients(Long id, String first_name, String last_name, Sex sex, Long egn, City city){
        this.id = id;
        this.firstName = first_name;
        this.lastName = last_name;
        this.sex = sex;
        this.egn = egn;
        this.city = city;
    }

    public Clients(Long id, String firstName, String secondName, String lastName, String nickName,
                   Sex sex, Long egn, City city, Double current, Double saving, Double credit){
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.sex = sex;
        this.egn = egn;
        this.city = city;
        this.current = current;
        this.saving = saving;
        this.credit = credit;
    }

    public Clients(String first_name, String last_name, Sex sex, Long egn) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.sex = sex;
        this.egn = egn;
    }
}
