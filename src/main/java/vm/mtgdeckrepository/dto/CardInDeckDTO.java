package vm.mtgdeckrepository.dto;

public class CardInDeckDTO {
    private String card_name;
    private int quantity;

    public CardInDeckDTO() {}

    public CardInDeckDTO(String card_name, int quantity) {
        this.card_name = card_name;
        this.quantity = quantity;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
