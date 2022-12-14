package sapronov.atm.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "role_name")
    private String role_name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public int getId() {
        return id;
    }
    public String getRole_name() {
        return role_name;
    }
    public void setRole_name(String name) {
        this.role_name = name;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Role() {
    }
    public Role(String role_name) {
        this.role_name = role_name;
    }
}
