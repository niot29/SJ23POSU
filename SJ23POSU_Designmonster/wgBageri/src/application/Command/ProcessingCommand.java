package application.Command;

import application.BusinessObject.Cake;
import application.CakeBuilder.Builder;

public interface ProcessingCommand {
    //String process(String str);

    Cake process(Cake cake);
}
