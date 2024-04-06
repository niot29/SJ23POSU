package se.sakilagui;

import se.sakilagui.Controller.ActorController;
import se.sakilagui.Model.ActorEntity;

public class Test_Actor {
     static ActorController actorController = new ActorController();

    public void create(){
        ActorEntity actorEntity = new ActorEntity();
        actorEntity.setFirst_name("Kung");
        actorEntity.setLast_name("Kalle");
        actorController.create(actorEntity);
    }

    public void getActorById(){
        System.out.println(actorController.getActorById(201));
    }

    public void listActors(){
        System.out.println(actorController.getActorById(1));
        for(ActorEntity actorEntity: actorController.listActors()){
            System.out.println("ActorObjList: " + actorEntity);
        }
    }

    public void  updateActor(){
        ActorEntity actorEntity = actorController.getActorById(201);
        actorEntity.setFirst_name("XXX");
        actorEntity.setLast_name("YYY");
        actorController.updateActor(actorEntity);
    }

    public void deleteActorById(){
        actorController.deleteActorById(201);
    }
}
