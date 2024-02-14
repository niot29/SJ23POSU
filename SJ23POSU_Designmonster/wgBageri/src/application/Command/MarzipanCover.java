package application.Command;

import application.BusinessObject.Cake;
import application.CakeBuilder.Builder;

import java.util.ArrayList;
import java.util.List;

//-- Lägg marsipanlocket på tårtan (grön/röd)
public class MarzipanCover implements ProcessingCommand{
    @Override
    public Cake process(Cake cake) {
        String str = "Röd";
        if(cake.getName().equals("PrincessCake")){
            str = "Grön";
        }

        String result = "Command: Lägg " + str + " marsipanlocket på tårtan";

        List<String> list = new ArrayList<String>();
        for(String s : cake.getDecoratedStep()){
            list.add(s);
        }
        list.add(result);
        cake.setDecoratedStep(list);
        return cake;
    }
}
