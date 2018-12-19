package net.fexcraft.mod.fvtm.prototype;

import net.fexcraft.mod.fvtm.blocks.rail.Connection;

public class ConnContainer {
	
	public Connection[] connections;
	public boolean switch0;//switch1 in the future for 2 sided switches
	
	public ConnContainer(){
		this.connections = new Connection[0]; this.switch0 = false;
	}
	
	public ConnContainer(Connection[] arr){
		this(arr, false);
	}

	public ConnContainer(Connection[] conns, boolean bool){
		this.connections = conns; this.switch0 = bool;
	}

	public ConnContainer(Connection conn){
		this(new Connection[]{ conn });
	}

	public void remove(int j){
		if(connections.length <= 1){
			connections = new Connection[0]; return;
		}
		Connection[] newconns = new Connection[connections.length - 1];
		int c = 0; for(int i = 0; i < connections.length; i++){
			if(i == j) continue; newconns[c++] = connections[i];
		} connections = newconns;
	}

	public void addnew(Connection conn){
		if(this.connections == null || this.connections.length <= 0){
			connections = new Connection[]{ conn }; return;
		}
		Connection[] newconns = new Connection[connections.length + 1];
		for(int i = 0; i < connections.length; i++){
			newconns[i] = connections[i];
		} newconns[newconns.length - 1] = conn;
		connections = newconns;
	}
	
}