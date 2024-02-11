package Command;

// --Garnera med marsipanros
public class MarzipanGarnish implements ProcessingCommand{
    @Override
    public String process(String str) {
        String result = "Command: Garnera med marsipanros: ";
        System.out.println(result);
        return result;
    }
}
