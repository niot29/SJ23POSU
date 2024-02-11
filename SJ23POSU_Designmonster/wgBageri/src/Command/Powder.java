package Command;


import BusinessObject.Cake;
import CakeBuilder.Builder;

import java.util.ArrayList;
import java.util.List;

// --Pudra över florsocker
public class Powder implements ProcessingCommand{
    @Override
    public Cake process(Cake cake) {
        String result = "Command: Pudra över florsocker";
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
