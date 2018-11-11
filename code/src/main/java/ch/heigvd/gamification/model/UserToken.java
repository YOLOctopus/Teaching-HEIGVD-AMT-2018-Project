package ch.heigvd.gamification.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "UserToken.findByToken", query = "SELECT u FROM UserToken u WHERE u.token = :token"),
})
public class UserToken extends AbstractDomainModelEntity<Long>  {
    @ManyToOne
    User user;

    @Column(nullable = false)
    String token;

    public UserToken() {}

    public UserToken(User user) {
        this.user = user;
        token = UUID.randomUUID().toString();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
