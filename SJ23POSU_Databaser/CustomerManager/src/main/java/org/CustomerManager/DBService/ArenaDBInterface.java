package org.CustomerManager.DBService;

import org.CustomerManager.Model.Address;
import org.CustomerManager.Model.Arena;

import java.util.List;

public interface ArenaDBInterface {

    public int create(Arena arena);

    public Arena getArenaById(int id);

    public List<Arena> ListArena();

    public Arena updateArena(Arena arena);

    void deleteArenaById(int id);

}
