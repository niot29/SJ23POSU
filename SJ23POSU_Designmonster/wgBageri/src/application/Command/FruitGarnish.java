package application.Command;

import application.BusinessObject.Cake;
import application.CakeBuilder.Builder;

import java.util.ArrayList;
import java.util.List;

//-- Garnera med hallon
public class FruitGarnish implements ProcessingCommand{
    @Override
    public Cake process(Cake cake) {
        String result = "Command: Garnera med hallon";

        List<String> list = new ArrayList<String>();
        for(String s : cake.getDecoratedStep()){
            list.add(s);
        }
        list.add(result);
        cake.setDecoratedStep(list);

        return cake;
    }
}
