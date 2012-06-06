package de.uvwxy.footpath2.tools;

import android.graphics.Bitmap;
import de.uvwxy.footpath2.map.IndoorLocation;

/**
 * This is a class to maintain a tile. The tile is stored in a bitmap.
 * @author Paul Smith
 * 
 */
public class Tile {
	int zoomlevel;
	int x;
	int y;
	Bitmap bitmap;

	public Tile(int zoomlevel, int x, int y, Bitmap bitmap) {
		this.zoomlevel = zoomlevel;
		this.x = x;
		this.y = y;
		this.bitmap = bitmap;
	}

	public int getZoomlevel() {
		return zoomlevel;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setZoomlevel(int zoomlevel) {
		this.zoomlevel = zoomlevel;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	public IndoorLocation getLatLonPosLeftTop() {
		// source: http://wiki.openstreetmap.org/wiki/Slippy_map_tilenames
		double lon = 0.0;
		double lat = 0.0;
		double n = Math.pow(2, zoomlevel);
		lon = x / n * 360.0 - 180.0;
		double lat_rad = Math.atan(Math.sinh(Math.PI * (1.0 - 2.0 * y / n)));
		lat = lat_rad * 180.0 / Math.PI;
		IndoorLocation ret = new IndoorLocation("", "");
		ret.setLatitude(lat);
		ret.setLongitude(lon);
		ret.setLevel(-1337);
		return ret;
	}

	public IndoorLocation getLatLonPosRightBottom() {
		// source: http://wiki.openstreetmap.org/wiki/Slippy_map_tilenames
		double lon = 0.0;
		double lat = 0.0;
		double n = Math.pow(2, zoomlevel);
		lon = (x + 1) / n * 360.0 - 180.0;
		double lat_rad = Math.atan(Math.sinh(Math.PI * (1.0 - 2.0 * (y + 1) / n)));
		lat = lat_rad * 180.0 / Math.PI;
		IndoorLocation ret = new IndoorLocation("", "");
		ret.setLatitude(lat);
		ret.setLongitude(lon);
		ret.setLevel(-1337);
		return ret;
	}
}