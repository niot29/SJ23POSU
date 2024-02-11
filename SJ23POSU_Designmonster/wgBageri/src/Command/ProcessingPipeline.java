package Command;

import java.util.ArrayList;

public class ProcessingPipeline {
    private ArrayList<ProcessingCommand> pipeline = new ArrayList<ProcessingCommand>();

    public void addCommand(ProcessingCommand cmd){
        pipeline.add(cmd);
    }

    public String execute(String str){
        String result = str;
        for(ProcessingCommand cmd: pipeline){
            result = cmd.process(result);
        }
        return result;
    }
}
