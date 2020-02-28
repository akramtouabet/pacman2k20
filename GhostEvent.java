package pacman;


	public class GhostEvent {
		private Coordinate coordinate;
		
		public GhostEvent(Coordinate coordinate)
		{
			this.coordinate = coordinate;
		}
		
		public Coordinate getCoordinate()
		{
			return coordinate;
		}
	}
