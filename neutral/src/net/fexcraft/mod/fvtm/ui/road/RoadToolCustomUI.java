package net.fexcraft.mod.fvtm.ui.road;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadToolCustomUI extends UserInterface {

	protected RoadToolCustomCon rtc;
	protected boolean sscr;
	protected float seg;

	public RoadToolCustomUI(JsonMap map, ContainerInterface con) throws Exception{
		super(map, con);
		rtc = (RoadToolCustomCon)con;
		sscr = rtc.rt_width > 8;
		tabs.get("left").visible(sscr);
		tabs.get("right").visible(sscr);
		tabs.get("full0").visible(sscr);
		tabs.get("full1").visible(sscr);
		tabs.get("full2").visible(sscr);
		tabs.get("scroll").visible(sscr);
		buttons.get("scroll_left").visible(sscr);
		buttons.get("scroll_right").visible(sscr);
		seg = 162f / rtc.rt_width;
	}

	@Override
	public void predraw(float ticks, int mx, int my){

	}

	@Override
	public void drawbackground(float ticks, int mx, int my){
		if(!sscr){
			int left = gLeft + 88 - rtc.offset;
			drawer.draw(left - 7, gTop, 0, 0, 25, 32);
			if(rtc.rt_width == 1){
				drawer.draw(left + 18, gTop, 61, 0, 7, 32);
			}
			else{
				for(int i = 1; i < rtc.rt_width - 1; i++){
					drawer.draw(left + i * 18, gTop, 25, 0, 18, 32);
				}
				drawer.draw(left + (rtc.rt_width - 1) * 18, gTop, 43, 0, 25, 32);
			}
		}
		else{
			float b = seg * rtc.scroll;
			float w = seg * 9;
			drawer.draw(gLeft + 7 + b, gTop - 18, 7, 151, (int)w, 6);
			drawer.draw(gLeft + 3.5f + b + (w / 2), gTop - 24, 177, 132, 7, 7);
		}
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int b){
		switch(id){
			case "scroll_left":{
				scroll(-1);
				return true;
			}
			case "scroll_right":{
				scroll(1);
				return true;
			}
		}
		return false;
	}

	private void scroll(int by){
		TagCW com = TagCW.create();
		com.set("cargo", "scroll");
		com.set("by", by);
		container.SEND_TO_SERVER.accept(com);
		rtc.scroll += by;
		if(rtc.scroll < 0) rtc.scroll = 0;
		if(rtc.scroll + 9 >= rtc.rt_width) rtc.scroll = rtc.rt_width - 9;
	}

	@Override
	public void scrollwheel(int am, int mx, int my){
		if(my < gTop + 36) scroll(am < 0 ? 1 : -1);
	}

	@Override
	public boolean keytyped(char c, int code){
		if(code == 1){
			TagCW com = TagCW.create();
			com.set("ui", UIKeys.ROAD_TOOL.id);
			com.set("pos", V3I.NULL.toIntegerArray());
			Packets.send(Packet_TagListener.class, "open_ui", com);
		}
		return true;
	}

	@Override
	public boolean onClick(int mx, int my, int mb){
		if(mb == 0 && mx >= gLeft + 7 && mx <= gLeft + 169 && my >= gTop - 18 && my <= gTop - 12){
			int sg = (int)((mx - gLeft - 7) / seg);
			if(sg < 0) sg = 0;
			if(sg >= rtc.rt_width - 9) sg = rtc.rt_width - 9;
			scroll(sg - rtc.scroll);
			return true;
		}
		return super.onClick(mx, my, mb);
	}

	@Override
	public void getTooltip(int mx, int my, List<String> list){
		if(rtc.rt_width < 9) return;
		if(tabs.get("scroll").hovered(gLeft, gTop, mx, my)){
			Object[] objs = new Object[]{ rtc.scroll + 1, rtc.scroll + 9, rtc.rt_width };
			list.add(container.TRANSFORMAT.apply("ui.fvtm.road_tool_custom.scroll_status", objs));
		}
	}


}
