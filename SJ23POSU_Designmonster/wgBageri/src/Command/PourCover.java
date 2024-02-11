package Command;

//-- Häll chokladganash på tårtan. Låt det rinna över kanten
public class PourCover implements ProcessingCommand{
    @Override
    public String process(String str) {
        String result = "Command: Häll chokladganash på tårtan. Låt det rinna över kanten";
        System.out.println(result);
        return result;
    }
}
