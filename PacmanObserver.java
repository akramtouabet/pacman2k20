package pacman;

import java.util.List;

public interface PacmanObserver {
	public void notify(List<PacmanEvent> events) ; 
}

