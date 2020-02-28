package pacman;


	public class PacmanEvent {
		private Coordinate coordinate;
		
		public PacmanEvent(Coordinate coordinate)
		{
			this.coordinate = coordinate;
		}
		
		public Coordinate getCoordinate()
		{
			return coordinate;
		}
	}
