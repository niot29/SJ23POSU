package Command;

import BusinessObject.Cake;
import CakeBuilder.Builder;

import java.util.ArrayList;
import java.util.List;

// -- Spackla tårtan med chokladsmörkräm
public class ChooclateCover implements ProcessingCommand{
    @Override
    public Cake process(Cake cake) {
        String result = "Command: Spackla tårtan med chokladsmörkräm";
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
