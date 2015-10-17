package com.dev.ytachi0026.java6;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberWorker {
	public static final String FORMAT_DOS_DECIMALES = "###,###,###,##0.00";
	
	public static String formatNumber(Object number, String format){
		if (!isEmptyNumber(number)){
			DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
			dfs.setDecimalSeparator('.');
			dfs.setGroupingSeparator(',');
			NumberFormat formatter = new DecimalFormat(format, dfs);
			return formatter.format(number).toString().trim();
		}
		return StringWorker.EMPTY;
	}
	public static boolean isEmptyNumber(Object number){
		if(number == null){
			return true;
		}
		if(StringWorker.isEmptyString(number.toString())){
			return true;
		}
		if(!(number instanceof Number)){
			return true;
		}
		return false;
	}
	public static boolean isNumber(Number number){
		if(number == null){
			return false;
		}
		return true;
	}
	
	
}
