package kr.co.rebel9.memexcms.config.web;

/**
 * Comment : primitive value from the specified 'Object'<br />
 * History : 1st<br />
 * @version : 1.0<br />
 * @author : Copyright(c) x. All Rights Reserved. someone<br />
 */
public class DataType { 
	/**
	 * Returns the double value from the specified 'Object'
	 */
	public static double doubleValue(Object o, double x) {
		if (o == null) return x;

		if (o instanceof Number) {
			return ((Number)o).doubleValue();
		} else if (o instanceof Boolean) {
			return ((Boolean)o).booleanValue() ? 1:0;
		} else if (o instanceof String) {
			try {
				return Double.parseDouble((String)o);
			} catch (Exception e) {
			}
		}
		return x;
	}
	public static double doubleValue(Object o) {
		return doubleValue(o, Double.NaN);
	}

	/**
	 * Returns the float value from the specified 'Object'
	 */
	public static float floatValue(Object o, float x) {
		if (o == null) return x;

		if (o instanceof Number) {
			return ((Number)o).floatValue();
		} else if (o instanceof Boolean) {
			return ((Boolean)o).booleanValue() ? 1:0;
		} else if (o instanceof String) {
			try {
				return Float.parseFloat((String)o);
			} catch (Exception e) {
			}
		}
		return x;
	}
	public static float floatValue(Object o) {
		return floatValue(o, Float.NaN);
	}

	/**
	 * Returns the long value from the specified 'Object'
	 */
	public static long longValue(Object o, long x) {
		if (o == null) return x;

		if (o instanceof Number) {
			return ((Number)o).longValue();
		} else if (o instanceof Boolean) {
			return ((Boolean)o).booleanValue() ? 1:0;
		} else if (o instanceof String) {
			try {
				return Long.parseLong((String)o);
			} catch (Exception e) {
			}
		}
		return x;
	}
	public static long longValue(Object o) {
		return longValue(o, 0);
	}

	/**
	 * Returns the int value from the specified 'Object'
	 */
	public static int intValue(Object o, int x) {
		if (o == null) return x;

		if (o instanceof Number) {
			return ((Number)o).intValue();
		} else if (o instanceof Boolean) {
			return ((Boolean)o).booleanValue() ? 1:0;
		} else if (o instanceof String) {
			try {
				return Integer.parseInt((String)o);
			} catch (Exception e) {
			}
		}
		return x;
	}
	public static int intValue(Object o) {
		return intValue(o, 0);
	}

	/**
	 * Returns the short value from the specified 'Object'
	 */
	public static short shortValue(Object o, short x) {
		if (o == null) return x;

		if (o instanceof Number) {
			return ((Number)o).shortValue();
		} else if (o instanceof Boolean) {
			return ((Boolean)o).booleanValue() ? (short)1:(short)0;
		} else if (o instanceof String) {
			try {
				return Short.parseShort((String)o);
			} catch (Exception e) {
			}
		}
		return x;
	}
	public static short shortValue(Object o) {
		return shortValue(o, (short)0);
	}

	/**
	 * Returns the byte value from the specified 'Object'
	 */
	public static byte byteValue(Object o, byte x) {
		if (o == null) return x;

		if (o instanceof Number) {
			return ((Number)o).byteValue();
		} else if (o instanceof Boolean) {
			return ((Boolean)o).booleanValue() ? (byte)1:(byte)0;
		} else if (o instanceof String) {
			try {
				return Byte.parseByte((String)o);
			} catch (Exception e) {
			}
		}
		return x;
	}
	public static byte byteValue(Object o) {
		return byteValue(o, (byte)0);
	}

	/**
	 * Returns the boolean value from the specified 'Object'
	 */
	public static boolean booleanValue(Object o, boolean x) {
		if (o == null) return x;

		if (o instanceof Double) {
			return ((Number)o).doubleValue() != 0 ? true:false;
		} else if (o instanceof Float) {
			return ((Number)o).floatValue() != 0 ? true:false;
		} else if (o instanceof Number) {
			return ((Number)o).longValue() != 0 ? true:false;
		} else if (o instanceof Boolean) {
			return ((Boolean)o).booleanValue();
		} else if (o instanceof String) {
			try {
				return Boolean.parseBoolean((String)o);
			} catch (Exception e) {
			}
		}
		return x;
	}
	public static boolean booleanValue(Object o) {
		return booleanValue(o, false);
	}

}
