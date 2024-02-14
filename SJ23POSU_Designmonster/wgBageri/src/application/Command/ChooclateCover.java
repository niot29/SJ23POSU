package application.Command;

import application.BusinessObject.Cake;
import application.CakeBuilder.Builder;

import java.util.ArrayList;
import java.util.List;

// -- Spackla tårtan med chokladsmörkräm
public class ChooclateCover implements ProcessingCommand {
	@Override
	public Cake process(Cake cake) {
		String result = "Command: Spackla tårtan med chokladsmörkräm";

		List<String> list = new ArrayList<String>();

		if (cake.getDecoratedStep() !=null ) {

			for (String s : cake.getDecoratedStep()) {
				list.add(s);
			}
		}

		list.add(result);
		cake.setDecoratedStep(list);

		return cake;
	}
}
