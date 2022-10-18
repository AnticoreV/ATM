package sapronov.atm.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accounts")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "money_count")
    private int money_count;

    public Account() {
    }
    public Account(int money_count) {
        this.money_count = money_count;
    }
    public double getMoney_count() {
        return money_count;
    }
    public void setMoney_count(int money_count) {
        this.money_count = money_count;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
