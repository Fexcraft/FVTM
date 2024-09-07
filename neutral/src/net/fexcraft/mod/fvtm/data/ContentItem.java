package net.fexcraft.mod.fvtm.data;

import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WrapperHolder;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public interface ContentItem<TYPE extends Content<TYPE>> {

	public TYPE getContent();

	public ContentType getType();

	public interface ContentDataItem<TYPE extends Content<TYPE>, DATA extends ContentData<TYPE, DATA>> extends ContentItem<TYPE> {

		public default DATA getData(StackWrapper stack){
			return null;
		}

		public default DATA getData(TagCW compound){
			return null;
		}

		public default DATA getDataFromTag(Object compound){
			return getData(compound == null ? null : TagCW.wrap(compound));
		}

	}

}
