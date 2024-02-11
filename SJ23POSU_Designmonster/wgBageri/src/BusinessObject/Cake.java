package BusinessObject;

import java.util.List;

public class Cake {
    int id;
    String name;
    String cakeBottomLayer;
    String cakeBottomCream;
    String cakeMiddleLayer;
    String cakeMiddleCream;
    String cakeTopLayer;
    String cakeTopCream;

    List<String> decoratedStep;

    public Cake(int id, String name, String cakeBottomLayer, String cakeBottomCream, String cakeMiddleLayer, String cakeMiddleCream, String cakeTopLayer, String cakeTopCream, List<String> decoratedStep) {
        this.id = id;
        this.name = name;
        this.cakeBottomLayer = cakeBottomLayer;
        this.cakeBottomCream = cakeBottomCream;
        this.cakeMiddleLayer = cakeMiddleLayer;
        this.cakeMiddleCream = cakeMiddleCream;
        this.cakeTopLayer = cakeTopLayer;
        this.cakeTopCream = cakeTopCream;
        this.decoratedStep = decoratedStep;
    }


    public Cake() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCakeBottomLayer() {
        return cakeBottomLayer;
    }

    public void setCakeBottomLayer(String cakeBottomLayer) {
        this.cakeBottomLayer = cakeBottomLayer;
    }

    public String getCakeBottomCream() {
        return cakeBottomCream;
    }

    public void setCakeBottomCream(String cakeBottomCream) {
        this.cakeBottomCream = cakeBottomCream;
    }

    public String getCakeMiddleLayer() {
        return cakeMiddleLayer;
    }

    public void setCakeMiddleLayer(String cakeMiddleLayer) {
        this.cakeMiddleLayer = cakeMiddleLayer;
    }

    public String getCakeMiddleCream() {
        return cakeMiddleCream;
    }

    public void setCakeMiddleCream(String cakeMiddleCream) {
        this.cakeMiddleCream = cakeMiddleCream;
    }

    public String getCakeTopLayer() {
        return cakeTopLayer;
    }

    public void setCakeTopLayer(String cakeTopLayer) {
        this.cakeTopLayer = cakeTopLayer;
    }

    public String getCakeTopCream() {
        return cakeTopCream;
    }

    public void setCakeTopCream(String cakeTopCream) {
        this.cakeTopCream = cakeTopCream;
    }

    public List<String> getDecoratedStep() {
        return decoratedStep;
    }

    public void setDecoratedStep(List<String> decoratedStep) {
        this.decoratedStep = decoratedStep;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cakeBottomLayer='" + cakeBottomLayer + '\'' +
                ", cakeBottomCream='" + cakeBottomCream + '\'' +
                ", cakeMiddleLayer='" + cakeMiddleLayer + '\'' +
                ", cakeMiddleCream='" + cakeMiddleCream + '\'' +
                ", cakeTopLayer='" + cakeTopLayer + '\'' +
                ", cakeTopCream='" + cakeTopCream + '\'' +
                ", decoratedStep=" + decoratedStep +
                '}';
    }
}

