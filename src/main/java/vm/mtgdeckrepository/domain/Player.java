package vm.mtgdeckrepository.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Player {
    @Id
    @GeneratedValue
    private long player_id;

    @Column(unique = true)
    private String username;

    private String password;

    private boolean administrator;

    public Player() {}

    public Player(String username, String password, boolean administrator) {
        this.username = username;
        this.password = password;
        this.administrator = administrator;
    }

    public long getPlayer_id() {
        return player_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }
}
