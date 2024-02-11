package Command;

import BusinessObject.Cake;
import CakeBuilder.Builder;

import java.util.ArrayList;

public class ProcessingPipeline {
    private ArrayList<ProcessingCommand> pipeline = new ArrayList<ProcessingCommand>();

    public void addCommand(ProcessingCommand cmd){
        pipeline.add(cmd);
    }

    public Cake execute(Cake cake){
        //System.out.println("ProcessingPipeline");

        //String result = str;
        for(ProcessingCommand cmd: pipeline){
            cake = cmd.process(cake);
        }


        return cake;
    }
}
