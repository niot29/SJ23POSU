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
        cake = director.pipelinePrincessCake(cake);
        System.out.println(cake);
        System.out.println("============================");

       director.buildOperaCake(builder);
       builder.addCakId(2);
       Cake cake2 = builder.build();
       cake2 = director.pipelineOperaCake(cake2);
       System.out.println(cake2);

       System.out.println("============================");
       director.buildChocolateCake(builder);
       builder.addCakId(3);
       Cake cake3 = builder.build();
       cake3 = director.pipelineChocolateCake(cake3);
       System.out.println(cake3);


    }
}