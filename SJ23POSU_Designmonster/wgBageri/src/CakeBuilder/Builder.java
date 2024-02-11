package CakeBuilder;

public interface Builder {

    public CakeBuilder addCakId(int cakeId);
    public CakeBuilder addCakeName(String cakeName);
    public CakeBuilder addCakeBottumLayer(String cakeLayer);
    public CakeBuilder addCakeBottumCream(String  cakeCream);
    public CakeBuilder addCakeMiddleLayer(String cakeLayer);
    public CakeBuilder addCakeMiddleCream(String  cakeCream);

    public CakeBuilder addCakeTopLayer(String cakeLayer);
    public CakeBuilder addCakeTopCream(String  cakeCream);
}
