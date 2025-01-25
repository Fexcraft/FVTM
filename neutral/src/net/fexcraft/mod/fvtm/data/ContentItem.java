package net.fexcraft.mod.fvtm.data;

import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;

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
