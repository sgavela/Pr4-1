package es.ucm.fdi.model.event;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.RoadMap;
import es.ucm.fdi.model.simulatedobject.Junction;

public class NewJunction extends Event {
	private String id;

	public NewJunction(int time, String id) {
		this.time = time;
		this.id = id;
	}
	
	public NewJunction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(RoadMap simObjects) {
		simObjects.addJunction(new Junction(id));
	}
	
	public class Builder implements Event.Builder{
		@Override
		public Event parse(IniSection sec) {
			if(!sec.getTag().equals("new_junction")) return null;
			return new NewJunction(parseInt(sec, "time", 0), sec.getValue("id"));
		}
	}

}
