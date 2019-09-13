package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;
import java.util.Collections;

@Deprecated
public class Chain {
	
	public ArrayList<RailEntity> entities = new ArrayList<>();
	
	public Chain(){}

	public boolean isFirstUnit(RailEntity rail){
		return size() > 0 && entities.get(0).uid == rail.uid;
	}

	public boolean isLastUnit(RailEntity rail){
		return size() > 0 && entities.get(entities.size() - 1).uid == rail.uid;
	}

	public void moveAll(float am){
		RailEntity entity;
		if(am > 0){
			for(int i = 1; i < size(); i++){
				(entity = entities.get(i)).moverq += entity.isHeadingForward() ? am : -am;
			}
		}
		else{
			for(int i = size() - 2; i > 0; i--){
				(entity = entities.get(i)).moverq += entity.isHeadingForward() ? -am : am;
			}
		}
	}

	public RailEntity getHead(){
		RailEntity ent = entities.get(0);//TODO check this
		return ent.front.hasEntity() != ent.isHeadingForward() ? ent : entities.get(size() - 1);
	}

	public void remove(RailEntity root){
		if(entities.isEmpty()){ root.chain = null; return; } boolean pass = false;
		if(entities.get(0).uid == root.uid){ entities.remove(0).chain = null; pass = true; }
		if(entities.get(size() - 1).uid == root.uid){ entities.remove(size() - 1).chain = null; pass = true; }
		if(size() < 2){ entities.get(0).chain = null; pass = true; } if(pass) return;
		int idx = entities.indexOf(root);
		ArrayList<RailEntity> arr0 = splitList(0, idx), arr1 = splitList(idx, size());
		if(arr0.size() < 2) arr0.forEach(rail -> rail.chain = null);
		else{ Chain chain0 = new Chain(); arr0.forEach(rail -> rail.chain = chain0); }
		if(arr1.size() < 2) arr1.forEach(rail -> rail.chain = null);
		else{ Chain chain1 = new Chain(); arr1.forEach(rail -> rail.chain = chain1); }
	}
	
	private ArrayList<RailEntity> splitList(int i, int j){
		ArrayList<RailEntity> list = new ArrayList<>();
		for(int k = i; k < j; k++) list.add(entities.get(k)); return list;
	}

	public int size(){
		return entities.size();
	}

	public void insert(RailEntity inchain, RailEntity newin){
		int index = entities.indexOf(inchain);
		if(newin.chain == null){
			entities.add(index == 0 ? 0 : index + 1, newin); newin.chain = this;
		}
		else{
			if(index == 0){
				ArrayList<RailEntity> list = new ArrayList<>(newin.chain.entities);
				Collections.reverse(list); entities.addAll(0, list);
			} else{ entities.addAll(index, newin.chain.entities); }
			entities.forEach(ent -> ent.chain = this);
		}
	}

}
