package se.sakilagui.Model;

public enum RatingEnum {
    RATING_UNRATED("UNRATED"),
    RATING_G("G"),
    RATING_PG("PG"),
    RATING_PG13("PG-13"),
    RATING_R("R"),
    RATING_NC17("NC17");

    private  String rating;
    RatingEnum(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }
}
