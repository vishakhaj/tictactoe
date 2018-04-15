package game.tictactoe.enums;

import game.tictactoe.Marker;

public enum Cell {
	EMPTY("Empty"), MARKER1(Marker.marker1), MARKER2(Marker.marker2);

	private Cell(final String marker) {
		this.marker = marker;
	}

	private String marker;

	public String getMarker() {
		return marker;
	}
}
