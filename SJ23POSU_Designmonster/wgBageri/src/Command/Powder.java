package Command;


// --Pudra över florsocker
public class Powder implements ProcessingCommand{
    @Override
    public String process(String str) {
        String result = "Command: Pudra över florsocker";
        System.out.println(result);
        return result;
    }
}
