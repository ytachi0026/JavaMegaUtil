package com.dev.ytachi0026.java6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateWorker {

	public static final String FORMAT_dd_MM_aaaa = "dd-MM-yyyy";
	public static final String FORMAT_aaaa_MM_dd = "yyyy-MM-dd";
	public static final String FORMAT_aaaaMMddhhmmss = "yyyyMMddhhmmss";
	public static final String FORMAT_aaaaMMdd= "yyyyMMdd";
	public static final String FORMAT_hhmmss = "hhmmss";
	public static final String FORMAT_hh_mm_ss = "hhmmss";
	public static final String FORMAT_HHmmss = "HH:mm:ss";
	public static final String FORMAT_HH_mm_ss = "HH:mm:ss";
	public static final String FORMAT_dd7MM7yyyy = "dd/MM/yyyy";
	public static final String FORMAT_dd7MM7yyyy_ahhmmss = "dd/MM/yyyy a hh:mm:ss";
	public static final String FORMAT_dd7MM7yyyy_HH_mm_ss = "dd/MM/yyyy HH:mm:ss";
	
	public static Date getDateFromString(String dateData, String format) throws IllegalStateException{
		try {
			SimpleDateFormat dateFormatter = new SimpleDateFormat(format);
			return dateFormatter.parse(dateData);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new IllegalStateException("Error en obtener Date");
		}
	}
	public static XMLGregorianCalendar getNowDateSchematTime() throws IllegalStateException{
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
		} catch (DatatypeConfigurationException e) {
			throw new IllegalStateException("No se puede obtener fecha actual en Schema Time");
		}
	}
	public static String getNowDateSchematTimeData() throws IllegalStateException{
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()).toString();
		} catch (DatatypeConfigurationException e) {
			throw new IllegalStateException("No se puede obtener fecha actual en Schema Time");
		}
	}
	
	public static XMLGregorianCalendar getNowDateSchemaDate() throws IllegalStateException{
		try {
			XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar();
			calendar.setYear(Calendar.getInstance().get(Calendar.YEAR));
			calendar.setMonth(Calendar.getInstance().get(Calendar.MONTH));
			calendar.setDay(Calendar.getInstance().get(Calendar.DATE));
			return calendar;
		} catch (DatatypeConfigurationException e) {
			throw new IllegalStateException("No se puede obtener fecha actual en Schema Date");
		}
	}
	public static String getNowDateSchemaDateData() throws IllegalStateException{
		try {
			XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar();
			calendar.setYear(Calendar.getInstance().get(Calendar.YEAR));
			calendar.setMonth(Calendar.getInstance().get(Calendar.MONTH));
			calendar.setDay(Calendar.getInstance().get(Calendar.DATE));
			return calendar.toString();
		} catch (DatatypeConfigurationException e) {
			throw new IllegalStateException("No se puede obtener fecha actual en Schema Date");
		}
	}
	
	public static String formatDate(XMLGregorianCalendar xmlGregorianCalendar, String format){
		SimpleDateFormat sdfGeneral = new SimpleDateFormat(format);
		if (xmlGregorianCalendar != null) {
			return sdfGeneral.format(xmlGregorianCalendar.toGregorianCalendar().getTime());
		}
		return StringWorker.EMPTY;
	}
	public static String formatDate(Date date, String format){
		SimpleDateFormat sdfGeneral = new SimpleDateFormat(format);
		if (date != null) {
			return sdfGeneral.format(date);
		}
		return StringWorker.EMPTY;
	}
	public static long daysBetween(Date d1, Date d2){
		return (long)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
}
