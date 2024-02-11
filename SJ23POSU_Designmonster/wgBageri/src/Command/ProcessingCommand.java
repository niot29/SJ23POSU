package Command;

import CakeBuilder.Builder;

public interface ProcessingCommand {
    String process(String str);

    //Builder process(Builder cakeBuilder);
}
