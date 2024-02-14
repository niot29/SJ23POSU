package application.Command;


import application.BusinessObject.Cake;
import application.CakeBuilder.Builder;

import java.util.ArrayList;
import java.util.List;

// -- Fördela hårt vispad grädde på tårtan så den får en kupolform
public class CreamDistrubute implements ProcessingCommand{
    @Override
    public Cake process(Cake cake) {
        //System.out.println("CreamDistrubute -- " + cake);
        String result = "Command: Fördela hårt vispad grädde på tårtan så den får en kupolform";
        List<String> list = new ArrayList<String>();
        list.add(result);
        cake.setDecoratedStep(list);
        return cake;


    }
}
