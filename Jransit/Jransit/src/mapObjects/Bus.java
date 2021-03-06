package mapObjects;

import java.io.File;
import java.io.FileNotFoundException;

import com.teamdev.jxmaps.Icon;
import com.teamdev.jxmaps.InfoWindow;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapMouseEvent;
import com.teamdev.jxmaps.Marker;
import com.teamdev.jxmaps.MouseEvent;
import com.teamdev.jxmaps.Size;

import info.BusInfo;

/**
 * Representation of buses
 * 
 * @author
 *
 */

public class Bus {
	private Marker marker;
	private Map map;
	private BusInfo info;

	/**
	 * Bus Constructor
	 * 
	 * @param map
	 *            the map the bus is on
	 * @param info
	 *            bus line information
	 * @param place
	 *            whether or not bus has been placed on map
	 */
	public Bus(Map map, BusInfo info, boolean place) {
		this.info = info;
		this.map = map;
		this.marker = new Marker(map);

		String basePath = (new File("").getAbsolutePath());
		File file = new File(basePath + "\\busIcons\\" + info.getLineName() + ".png");
		Icon ico = new Icon();
		if (file.exists()) {
			ico.loadFromFile(file);
		} else {
			file = new File(basePath + "\\busIcons\\bus.png");
			ico.loadFromFile(file);
		}
		ico.setScaledSize(new Size(24, 24));
		marker.setIcon(ico);
		if (place) {
			this.marker.setPosition(new LatLng(Double.valueOf(info.getLat()), Double.valueOf(info.getLng())));
		}
		// ADD CLOSE
		// ADD TIMES
		// ADD MORE STOPS
		this.marker.addEventListener("click", new MapMouseEvent() {
			@Override
			public void onEvent(MouseEvent mouseEvent) {
				int stopCounter = 1;
				InfoWindow infoWindow = new InfoWindow(map);
				StringBuilder stops = new StringBuilder();
				infoWindow.setContent("<p><big><b>" + info.getLineName() + " - " + info.getDestinationName()
						+ "</br> </b></big> " + " <b>Next Stop: </b>" + info.getNextStop() + ", <b>"
						+ info.getPresentableDistance() + "</b> </p>");
				infoWindow.open(map, marker);
			}
		});
	}

	public BusInfo getInfo() {
		return info;
	}

	public Map getMap() {
		return map;
	}

	public Marker getMarker() {
		return marker;
	}

	/**
	 * Update the marker position representing the bus
	 */
	public void updatePosition() {
		this.marker.setPosition(new LatLng(Double.valueOf(this.info.getLat()), Double.valueOf(this.info.getLng())));
	}

}