package net.fexcraft.lib.common.math;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Ferdinand Calo' (FEX___96)
 *
 * Generic Util for Time Stuff.
 */
public class Time {

	public static final long WEEK_MS = 604800000;
	public static final long DAY_MS = 86400000;
	public static final long HOUR_MS = 3600000;
	public static final long MIN_MS = 60000;
	public static final long SEC_MS = 1000;
	
	public static int getMonth(){
		return LocalDate.now().getMonthValue();
	}
	
	public static int getDay(){
		return LocalDate.now().getDayOfMonth();
	}
	
	public static int getDay365(){
		return LocalDate.now().getDayOfYear();
	}
	
	public static int getDay7(){
		return LocalDate.now().getDayOfWeek().getValue();
	}
	
	public static int getHour12(){
		int h = getHour24();
		return h >= 12 ? h - 12 : h;
	}
	
	public static int getHour24(){
		return LocalTime.now().getHour();
	}
	
	public static int getMinute(){
		return LocalTime.now().getMinute();
	}
	
	public static int getSecond(){
		return LocalTime.now().getSecond();
	}
	
	public static int getNano(){
		return LocalTime.now().getNano();
	}
	
	public static long getDate(){
		return new Date().getTime();
	}
	
	public static LocalTime getGMTOffset(int i){
		return getGMTOffset(i, false);
	}
	
	public static LocalTime getGMTOffset(int i, boolean control){
		if(control){ i = i > 12 ? i = 12 : i < -11 ? i = -11 : i; }
		return LocalTime.now(ZoneId.of("GMT" + (i >= 0 ? "+" + i : i)));
	}
	
	public static final String getAsString(long date){
		return getAsString(date, false);
	}
	
	public static final String getAsString(Long date, boolean filenamevalid){
		Date data = date == null || date < 0 ? new Date() : new Date(date);
		return (filenamevalid ? fileformat : format).format(data);
	}
	
	private static final SimpleDateFormat format = new SimpleDateFormat("dd|MM|yyyy HH:mm:ss");
	private static final SimpleDateFormat fileformat = new SimpleDateFormat("dd.MM.yyyy HH-mm-ss");
	
}