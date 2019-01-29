package net.fexcraft.mod.fvtm.api.root;

public class ResultEntry<K, V> implements java.util.Map.Entry<K, V> {
	
	private K key; private V val;
	
	public ResultEntry(K val0, V val1){
		key = val0; val = val1;
	}
	
	public ResultEntry(){}

	@Override
	public K getKey(){
		return key;
	}

	@Override
	public V getValue(){
		return val;
	}
	
	public ResultEntry<K, V> setKey(K key){
		this.key = key; return this;
	}

	@Override @Deprecated
	public V setValue(V value){
		V old = val; val = value; return old;
	}
	
	public ResultEntry<K, V> setVal(V val){
		this.val = val; return this;
	}
	
}