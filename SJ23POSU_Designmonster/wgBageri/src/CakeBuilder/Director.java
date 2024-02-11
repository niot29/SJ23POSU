package CakeBuilder;

import BusinessObject.Cake;
import Command.*;

public class Director {

    public void buildPlaneCake(Builder builder){
        builder.addCakeName("NoName")
                .addCakeBottumLayer("BottomLayer")
                .addCakeBottumCream("ButtomCream")
                .addCakeMiddleLayer("MiddleLayser")
                .addCakeMiddleCream("MiddleCream")
                .addCakeTopLayer("TopLayser")
                .addCakeTopCream("TopCream")
                .build();
    }

    public void buildPrincessCake(Builder builder){
        String color = "green";
        builder.addCakeName("PrincessCake")
                .addCakeBottumLayer("Add BottomLayer")
                .addCakeBottumCream("Add VanillaCream")
                .addCakeMiddleLayer("Add MiddleLayser")
                .addCakeMiddleCream("Add VanillaCream")
                .addCakeTopLayer("Add TopLayser")
                .build();

        ProcessingPipeline processingPipeline = new ProcessingPipeline();
        processingPipeline.addCommand(new CreamDistrubute());
        processingPipeline.addCommand(new MarzipanCover());
        processingPipeline.addCommand(new MarzipanGarnish());
        processingPipeline.addCommand(new Powder());
        processingPipeline.execute(color);

    }

    public void buildOperaCake(Builder builder){
        String color = "red";
        builder.addCakeName("Opera Cake")
                .addCakeBottumLayer("Add BottomLayer")
                .addCakeBottumCream("Add VanillaCream")
                .addCakeMiddleLayer("Add MiddleLayser")
                .addCakeMiddleCream("Add Raspberry Jam")
                .addCakeTopLayer("Add TopLayser")
                .build();

        ProcessingPipeline processingPipeline = new ProcessingPipeline();
        processingPipeline.addCommand(new CreamDistrubute());
        processingPipeline.addCommand(new MarzipanCover());
        processingPipeline.addCommand(new MarzipanGarnish());
        processingPipeline.addCommand(new Powder());
        processingPipeline.execute(color);
    }

    public void buildChocolateCake(Builder builder){
        String color = "Chocolate";
        builder.addCakeName("Chocolate Cake")
                .addCakeBottumLayer("Add Chocolate Bottom Layer")
                .addCakeBottumCream("Add Raspberry mousse")
                .addCakeMiddleLayer("Add Chocolate Middle Layser")
                .addCakeMiddleCream("Add Raspberry mousse")
                .addCakeTopLayer("Add Chocolate Top Layser")
                .build();

        ProcessingPipeline processingPipeline = new ProcessingPipeline();
        processingPipeline.addCommand(new ChooclateCover());
        processingPipeline.addCommand(new PourCover());
        processingPipeline.addCommand(new FruitGarnish());
        processingPipeline.execute(color);
    }
}
