package POJO.DeckOfCards;

import java.util.List;

public class DrawCards {

    boolean success;
    String deck_id;
    int remaining;
    List<Cards> cards;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
