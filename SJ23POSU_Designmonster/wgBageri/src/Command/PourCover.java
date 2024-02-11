package Command;

import BusinessObject.Cake;
import CakeBuilder.Builder;

import java.util.ArrayList;
import java.util.List;

//-- Häll chokladganash på tårtan. Låt det rinna över kanten
public class PourCover implements ProcessingCommand{
    @Override
    public Cake process(Cake cake) {
        String result = "Command: Häll chokladganash på tårtan. Låt det rinna över kanten";
        System.out.println(result);

        List<String> list = new ArrayList<String>();
        for(String s : cake.getDecoratedStep()){
            list.add(s);
        }
        list.add(result);
        cake.setDecoratedStep(list);

        return cake;
    }
}
