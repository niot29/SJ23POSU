import Command.PourCover;
import Command.MarzipanCover;
import Command.MarzipanGarnish;
import Command.ProcessingPipeline;
import BusinessObject.*;
import CakeBuilder.*;

public class Main {
    public static void main(String[] args) {



        /**
         * Build Plan cakae
         */

        Director director = new Director();
        CakeBuilder builder = new CakeBuilder();
        director.buildPrincessCake(builder);
        builder.addCakId(1);
        Cake cake = builder.build();

        System.out.println("============================");

       director.buildOperaCake(builder);
       builder.addCakId(2);
        builder.build();

       System.out.println("============================");
        director.buildChocolateCake(builder);
        builder.addCakId(3);
        builder.build();
    }
}