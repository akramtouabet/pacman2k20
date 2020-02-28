package pacman;

import java.util.List;

public interface GhostObserver {
	public void notifyGhost(List<GhostEvent> events) ; 
}

