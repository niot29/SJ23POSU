package se.sakilagui.Service;

import se.sakilagui.Model.ActorEntity;

import java.util.List;

public interface ActorDBInterface {
        public void create(ActorEntity actorEntity);

        public ActorEntity getActorById(int id);

        public List<ActorEntity> listActors();

        public ActorEntity updateActor(ActorEntity actor);

        public void deleteActorById(int id);
}




