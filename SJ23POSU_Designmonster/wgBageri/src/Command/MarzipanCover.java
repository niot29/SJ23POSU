package Command;

//-- Lägg marsipanlocket på tårtan (grön/röd)
public class MarzipanCover implements ProcessingCommand{
    @Override
    public String process(String str) {

        String result = "Command: Lägg " + str + " marsipanlocket på tårtan";
        System.out.println(result);
        return result;
    }
}
