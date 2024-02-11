package Command;

//-- Garnera med hallon
public class FruitGarnish implements ProcessingCommand{
    @Override
    public String process(String str) {
        String result = "Command: Garnera med hallon";
        System.out.println(result);
        return result;
    }
}
