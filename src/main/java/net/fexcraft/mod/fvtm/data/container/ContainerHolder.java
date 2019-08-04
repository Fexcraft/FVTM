package net.fexcraft.mod.fvtm.data.container;

import java.util.Collection;
import java.util.List;

public interface ContainerHolder {
	
	public Collection<List<ContainerSlot>> getContainerHolders();
	
	public static class ContainerSlot {
		
		public ContainerData data;
		public int length;
		
	}

}
