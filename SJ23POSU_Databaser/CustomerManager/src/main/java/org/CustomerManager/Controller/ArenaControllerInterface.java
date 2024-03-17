package org.CustomerManager.Controller;

import org.CustomerManager.Model.Arena;
import org.CustomerManager.Model.Customer;

public interface ArenaControllerInterface {
    public void createArena();

    public void listAllArena();

    public void listArena(Arena arena);

    public Arena getArenaById(int id);
    void updateArena(Arena arena);

    void deleteArena(Arena arena);
}
