package Command;

// -- Spackla tårtan med chokladsmörkräm
public class ChooclateCover implements ProcessingCommand{
    @Override
    public String process(String str) {
        String result = "Command: Spackla tårtan med chokladsmörkräm";
        System.out.println(result);
        return result;
    }
}
