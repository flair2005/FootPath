package de.uvwxy.footpath2.movement;

//hier variable anzahl an elementen - irgendwie blöd - oder?!
public class SensorTriple {
	public final static int NUM_ELEMENTS = 3;

	private final float[] values = new float[NUM_ELEMENTS];
	private final long ts;
	private final int type;

	public SensorTriple(float[] values, long ts, int type) {
		// nicht unbedingt schön, aber generischer.
		if (values.length != NUM_ELEMENTS)
			throw new IllegalArgumentException();

		for (int i = 0; i < NUM_ELEMENTS; i++) {
			this.values[i] = values[i];
		}

		this.ts = ts;
		this.type = type;
	}

	@Override
	public SensorTriple clone() {
		return new SensorTriple(values, ts, type);
	}

	/**
	 * @return the values
	 */
	public float[] getValues() {
		return values;
	}

	/**
	 * @return the ts
	 */
	public long getTs() {
		return ts;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
}
