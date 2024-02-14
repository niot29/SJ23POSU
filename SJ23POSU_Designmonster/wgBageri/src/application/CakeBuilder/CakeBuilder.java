package application.CakeBuilder;

import application.BusinessObject.Cake;

public class CakeBuilder implements  Builder{
  private Cake cake = new Cake();


  @Override
  public CakeBuilder addCakId(int cakeId) {
    cake.setId(cakeId);
    return this;
  }

  @Override
  public CakeBuilder addCakeName(String cakeName) {
    cake.setName(cakeName);
    return this;
  }

  @Override
  public CakeBuilder addCakeBottumLayer(String cakeLayer) {
    cake.setCakeBottomLayer(cakeLayer);
    //System.out.println("Build: Add Bottom Layer");
    return this;
  }

  @Override
  public CakeBuilder addCakeBottumCream(String cakeCream) {
    cake.setCakeBottomCream(cakeCream);
    //System.out.println("Build: Add Bottom ceram - " + cakeCream);
    return this;
  }

  @Override
  public CakeBuilder addCakeMiddleLayer(String cakeLayer) {
    cake.setCakeMiddleLayer(cakeLayer);
    //System.out.println("Build: Add Middle Layer");
    return this;
  }

  @Override
  public CakeBuilder addCakeMiddleCream(String cakeCream) {
    cake.setCakeMiddleCream(cakeCream);
    //System.out.println("Build: Add Middle cream - " + cakeCream);
    return this;
  }

  @Override
  public CakeBuilder addCakeTopLayer(String cakeLayer) {
    cake.setCakeTopLayer(cakeLayer);
    //System.out.println("Build: Add Topp Layer");
    return this;
  }

  @Override
  public CakeBuilder addCakeTopCream(String cakeCream) {
    cake.setCakeTopCream(cakeCream);
    //System.out.println("Build: Add Top cream - " + cakeCream);
    return this;
  }

  public Cake build(){
    if(cake.getName() == null){
      throw new RuntimeException("Missing cake Name");
    }
    return cake;
  }
}
