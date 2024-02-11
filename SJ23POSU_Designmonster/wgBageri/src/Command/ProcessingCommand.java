package Command;

import BusinessObject.Cake;
import CakeBuilder.Builder;

public interface ProcessingCommand {
    //String process(String str);

    Cake process(Cake cake);
}
