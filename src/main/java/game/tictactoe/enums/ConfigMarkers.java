package game.tictactoe.enums;

public enum ConfigMarkers {

	CROSS("X"), NOUGHT("O");
	
	private ConfigMarkers(final String marker) {
		this.marker = marker;
	}

	private String marker;

	public String getMarker() {
		return marker;
	}
}
