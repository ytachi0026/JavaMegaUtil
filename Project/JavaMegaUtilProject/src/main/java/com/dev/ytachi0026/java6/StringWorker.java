package com.dev.ytachi0026.java6;

public class StringWorker {

	public static final String NEXT_LINE = "\n";
	public static final String EMPTY = "";

	public static boolean isEmptyString(String string){
		if(string == null){
			return true;
		}
		if(string.trim().isEmpty()){
			return true;
		}
		return false;
	}
	
	public static String appendStrings(String...strings){
		StringBuilder result = new StringBuilder();
		for(String string: strings){
			result.append(string);
		}
		return isEmptyString(result.toString())?EMPTY:result.toString();
	}
	public static String markData(Object data){
		StringBuilder result =new StringBuilder();
		result.append("*");
		result.append(data);
		result.append("*");
		return result.toString();
	}
	public static String getData(Object data){
		if(data == null){
			return StringWorker.EMPTY;
		}
		if(isEmptyString(data.toString())){
			return StringWorker.EMPTY;
		}
		return data.toString();
	}
	public static String getDataCSV(Object data){
		StringBuilder result = new StringBuilder();
		result.append("\"");
		result.append(data);
		result.append("\"");
		return result.toString();
	}
	public static String getDataDepureCSV(Object data){
		StringBuilder result = new StringBuilder();
		result.append("\"");
		result.append(depureDataForCSV(data));
		result.append("\"");
		return result.toString();
	}
	public static String getHugeDataCSV(Object data){
		StringBuilder result = new StringBuilder();
		result.append("\"\'");
		result.append(data);
		result.append("\"");
		return result.toString();
	}
	public static String getHugeDataDepureCSV(Object data){
		StringBuilder result = new StringBuilder();
		result.append("\"\'");
		result.append(depureDataForCSV(data));
		result.append("\"");
		return result.toString();
	}
	
	public static  String depureDataForCSV(Object data){
		String dataDepure = getData(data).replace('"', ' ');
		dataDepure = dataDepure.replace('\'', ' ');
		dataDepure = dataDepure.replace(',', ' ');
		dataDepure = dataDepure.replace(';', ' ');
		return dataDepure;
	}
}
