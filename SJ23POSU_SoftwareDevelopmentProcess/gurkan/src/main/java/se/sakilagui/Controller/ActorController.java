package se.sakilagui.Controller;
import se.sakilagui.Model.ActorEntity;
import se.sakilagui.Service.ActorDBHandling;
import se.sakilagui.Service.ActorDBInterface;
import se.sakilagui.Service.ConvertTools;


import java.util.List;

public class ActorController implements ActorDBInterface {
    @Override
    public List<ActorEntity> listActors() {
        ActorDBHandling actorDBHandling = new ActorDBHandling();
        return actorDBHandling.listActors();

    }

    @Override
    public ActorEntity updateActor(ActorEntity actor) {
        ActorDBHandling actorDBHandling = new ActorDBHandling();
        ConvertTools convertTools = new ConvertTools();
        actor.setLastUpdate(convertTools.getlastUpdate());
        actorDBHandling.updateActor(actor);
        return actorDBHandling.getActorById(actor.getId());
    }


    @Override
    public ActorEntity getActorById(int id) {
        ActorDBHandling actorDBHandling = new ActorDBHandling();
        ActorEntity actorEntity = actorDBHandling.getActorById((short)id);
        return actorEntity;
    }
    @Override
    public void create(ActorEntity actor) {
        ActorDBHandling actorDBHandling = new ActorDBHandling();

        ConvertTools convertTools = new ConvertTools();
        actor.setLastUpdate(convertTools.getlastUpdate());

        actorDBHandling.create(actor);
    }
    @Override
    public void deleteActorById(int id) {
        ActorDBHandling actorDBHandling = new ActorDBHandling();
        actorDBHandling.deleteActorById(id);
    }
}