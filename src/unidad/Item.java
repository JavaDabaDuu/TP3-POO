package unidad;

import java.util.HashMap;

public abstract class Item {
	
	private HashMap bonus = new HashMap<String, Number>();
	
	protected abstract void aplicarbonus();
	
}
