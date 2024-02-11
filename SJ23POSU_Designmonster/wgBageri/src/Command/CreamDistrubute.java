package Command;


// -- Fördela hårt vispad grädde på tårtan så den får en kupolform
public class CreamDistrubute implements ProcessingCommand{
    @Override
    public String process(String str) {

        // Set color on next pipeline step
        String s = "grön";

        if(str.equals("red")){
            s = "röd";
        }
        String result = "Command: Fördela hårt vispad grädde på tårtan så den får en kupolform";
        System.out.println(result);
        return s;
    }
}
