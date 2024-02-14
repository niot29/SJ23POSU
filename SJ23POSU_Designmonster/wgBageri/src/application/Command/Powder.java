package application.Command;


import application.BusinessObject.Cake;
import application.CakeBuilder.Builder;

import java.util.ArrayList;
import java.util.List;

// --Pudra över florsocker
public class Powder implements ProcessingCommand{
    @Override
    public Cake process(Cake cake) {
        String result = "Command: Pudra över florsocker";

        List<String> list = new ArrayList<String>();
        for(String s : cake.getDecoratedStep()){
            list.add(s);
        }
        list.add(result);
        cake.setDecoratedStep(list);

        return cake;
    }
}
