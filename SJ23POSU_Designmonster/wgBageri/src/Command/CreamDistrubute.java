package Command;


import BusinessObject.Cake;
import CakeBuilder.Builder;

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
        System.out.println(result);
        return cake;


    }
}
