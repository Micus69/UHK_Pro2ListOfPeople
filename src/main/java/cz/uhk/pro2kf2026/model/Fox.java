package cz.uhk.pro2kf2026.model;

import jakarta.persistence.*;

@Entity
@Table(name = "foxs")
public class Fox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Změněno na Long, aby to sedělo s ostatními entitami

    private String name;
    private int age;
    private String place;

    @ManyToOne
    private User user;

    // Konstruktory
    public Fox() {
    }

    public Fox(String name, int age, String place) {
        this.name = name;
        this.age = age;
        this.place = place;
    }

    // Gettery a Settery
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // OPRAVENO: Tady se ti původně vracelo 'name' místo 'place'
    public String getPlace() {
        return place;
    }

    // OPRAVENO: Tady se ti původně ukládalo do 'name' místo 'place'
    public void setPlace(String place) {
        this.place = place;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}