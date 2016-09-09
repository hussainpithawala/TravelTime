package com.synerzip.utils.TimeUtils;

import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

public class TimeUtilities {
	public static String periodToString (Period period) {
		PeriodFormatter formatter = new PeriodFormatterBuilder().printZeroNever().appendHours()
				.appendSuffix("h").appendSeparator(":").appendMinutes().appendSuffix("m").toFormatter();
		return formatter.print(period);
	} 
}
