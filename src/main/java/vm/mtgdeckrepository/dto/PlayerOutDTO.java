package vm.mtgdeckrepository.dto;

import jakarta.persistence.Column;

public class PlayerOutDTO {
    private long player_id;
    private String username;
    private boolean administrator;

    public PlayerOutDTO(long player_id, String username, boolean administrator) {
        this.player_id = player_id;
        this.username = username;
        this.administrator = administrator;
    }

    public long getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(long player_id) {
        this.player_id = player_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }
}
