import org.apache.commons.lang3.EnumUtils;
import org.springframework.util.MultiValueMap;

import java.io.Serializable;
import java.util.*;

/**
 * Comment : ...<br />
 * History : 1st<br />
 * @version : 1.0<br />
 * @author : Copyright(c) x. All Rights Reserved. someone<br />
 */
@SuppressWarnings("unchecked")
public class DataMap implements Map<String, Object>, Cloneable, Serializable {
	private static final long serialVersionUID = 1985221488104628988L;

	private Map<String, Object> map = null;

	public DataMap() {
		this(new LinkedHashMap<>());
	}
	public DataMap(Map<String, Object> map) {
		if (map == null) {
			this.map = new LinkedHashMap<>();
		} else {
			this.map = map;
		}
	}
	public DataMap(MultiValueMap<String, Object> map) {
		this.map = new LinkedHashMap<>();
		if (map != null) {
			Set<String> keys = map.keySet();
			
			Object object = null;
			List<Object> list = null;
			for(String key : keys){
				object = map.get(key);
				if(object instanceof List){
					list = (List<Object>) object;
					if(list.size() == 1){
						object = list.get(0);
					}
				}
				this.map.put(key, object);
			}
		}
	}
	public DataMap(String key, Object object) {
		this(new LinkedHashMap<String, Object>());
		this.map.put(key, object);
	}
	public int size() {
		return map.size();
	}
	public boolean isEmpty() {
		return map.isEmpty();
	}
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}
	public Object get(Object key) {
		return map.get(key);
	}
	public Object put(String key, Object value) {
		return map.put(key, value);
	}
	public Object remove(Object key) {
		return map.remove(key);
	}
	public void putAll(Map<? extends String, ? extends Object> m) {
		map.putAll(m);
	}
	public void clear() {
		map.clear();
	}
	public Set<String> keySet() {
		return map.keySet();
	}
	public Collection<Object> values() {
		return map.values();
	}
	public Set<Entry<String, Object>> entrySet() {
		return map.entrySet();
	}

	public String toString() {
		return map.toString();
	}

	public Map<String,Object> getMap() {
		return map;
	}

	/**
	 * ...
	 */
	public <T extends Enum<T>> T getAsEnum(final String key, final Class<T> enumClass) {
		Object o = map.get(key);
		if (o == null) return null;
		return EnumUtils.getEnum(enumClass, o.toString());
	}

	/**
	 * ...
	 */
	public <T extends Enum<T>> List<T> getListAsEnum(final String key, final Class<T> enumClass) {
		Object o = map.get(key);
		if (o == null) return null;
		
		if(o instanceof List){
		    List<T> list = new ArrayList<T>();
		    List<String> oList = (List<String>) o;
		    for(String t : oList) {
		        T e = EnumUtils.getEnum(enumClass, t.toString());
		        if(e != null){
		            list.add(e);
		        }
		    }
		    
			return list; 
		}

    	    List<T> list = new ArrayList<T>();
    	    T e = EnumUtils.getEnum(enumClass, o.toString());
        if(e != null){
            list.add(e);
		}
        
        return list;
	}
	
	public DataMap getAsDataMap(String key) {
	    Object o = map.get(key);
	    
	    if (o == null) return null;
	    else if(o instanceof DataMap){
            return (DataMap) o;
        }
	    else if(o instanceof Map){
            return new DataMap((Map)o);
        }
	    
	    return new DataMap();
	}

	/**
	 * ...
	 */
	public String getAsString(String key) {
		Object o = map.get(key);
		if (o == null) return null;
		return o.toString();
	}

	/**
	 * ...
	 */
	public String[] getAsStrings(String key) {
		Object o = map.get(key);
		if (o == null) return null;
		
		String[] values = null;
		if(o instanceof String[]){
			values = (String[]) o;
		}
		else if(o instanceof List){
			values = ((List<String>) o).toArray(new String[((List<String>) o).size()]);
		}
		else {
			values = new String[]{getAsString(key)};
		}
		
		return values;
	}

	/**
	 * ...
	 */
	public List<String> getListAsString(String key)
    {
		Object o = map.get(key);
		if (o == null) return null;
		
		if(o instanceof List){
			return (List<String>) o; 
		}
		
        String[] values = null;
        if(o instanceof String[]){
        	values = (String[]) o;
		}
		else {
			values = new String[]{getAsString(key)};
		}
        
        List<String> list = new ArrayList<>();
		Collections.addAll(list, values);
        
        return list;
    }

	/**
	 * ...
	 */
	public List<Integer> getListAsInteger(String key)
    {
		Object o = map.get(key);
		if (o == null) return null;
		
		List<Integer> list = new ArrayList<Integer>();
		
		if(o instanceof List){
		    
		    List<?> values = (List<?>)o;
		    for(Object value : values) {
		        
		        if (value instanceof String) {
		            try{
	                    list.add(Integer.parseInt((String)value));
	                }catch(NumberFormatException ignored){}
                }
		        
		        else if(value instanceof Double) {
		            list.add(((Double)value).intValue());
		        }
            }
			
			return list; 
		}
        String[] values = null;
        if(o instanceof String[]){
            values = (String[]) o;
        }
        else {
            values = new String[]{getAsString(key)};
        }
        
        for(String value : values){
            try{
                list.add(Integer.parseInt(value));
            }catch(NumberFormatException e){
                try{
                	Double doubleValue = Double.parseDouble(value);
                    list.add(doubleValue.intValue());
                }catch(NumberFormatException ignored){ }
            }
        }
        
        return list;
    }

	/**
	 * ...
	 */
	public double getAsDouble(String key, double defaultValue) {
		Object o = map.get(key);
		return DataType.doubleValue(o, defaultValue);
	}
	public double getAsDouble(String k) {
		return getAsDouble(k, 0);
	}

	/**
	 * ...
	 */
	public float getAsFloat(String key, float defaultValue) {
		Object o = map.get(key);
		return DataType.floatValue(o, defaultValue);
	}
	public float getAsFloat(String key) {
		return getAsFloat(key, 0);
	}

	/**
	 * ...
	 */
	public long getAsLong(String key, long defaultValue) {
		Object o = map.get(key);
		return DataType.longValue(o, defaultValue);
	}
	public long getAsLong(String key) {
		return getAsLong(key, 0);
	}

	/**
	 * ...
	 */
	public int getAsInt(String key, int defaultValue) {
		Object o = map.get(key);
		return DataType.intValue(o, defaultValue);
	}
	public int getAsInt(String key) {
		return getAsInt(key, 0);
	}

	/**
	 * ...
	 */
	public int getAsShort(String key, short defaultValue) {
		Object o = map.get(key);
		return DataType.shortValue(o, defaultValue);
	}
	public int getAsShort(String key) {
		return getAsShort(key, (short)0);
	}

	/**
	 * ...
	 */
	public int getAsByte(String key, byte defaultValue) {
		Object o = map.get(key);
		return DataType.byteValue(o, defaultValue);
	}
	public int getAsByte(String key) {
		return getAsByte(key, (byte)0);
	}

	/**
	 * ...
	 */
	public boolean getAsBoolean(String key, boolean defaultValue) {
		Object o = map.get(key);
		if ("Y".equals(o)) return true;
		return DataType.booleanValue(o, defaultValue);
	}
	public boolean getAsBoolean(String key) {
		return getAsBoolean(key, false);
	}
}

