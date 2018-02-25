package es.ucm.fdi.model.event;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.simulatedobject.Junction;

public class NewRoad extends Event {
	private String id;
	private String src;
	private String dest;
	private int maxSpeed;
	private int length;

	public NewRoad(int time, String id, String src, String dest, int maxSpeed, int length) {
		this.time = time;
		this.id = id;
		this.src = src;
		this.dest = dest;
		this.maxSpeed = maxSpeed;
		this.length = length;
	}
	
	@Override
	public void execute() {
		
	}
	
	public class Builder implements EventBuilder{
		@Override
		public Event parse(IniSection sec) {
			if(!sec.getTag().equals("new_road")) return null;
			return new NewRoad(parseInt(sec, "time", 0), sec.getValue("id"), sec.getValue("src"), sec.getValue("dest"), parseInt(sec, "max_speed", 0), parseInt(sec, "length", 0));
		}
	}

}