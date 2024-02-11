package Command;

import BusinessObject.Cake;
import CakeBuilder.Builder;

import java.util.ArrayList;
import java.util.List;

//-- Garnera med hallon
public class FruitGarnish implements ProcessingCommand{
    @Override
    public Cake process(Cake cake) {
        String result = "Command: Garnera med hallon";
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
