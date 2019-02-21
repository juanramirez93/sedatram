package com.sedatram.utils;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

public class Utils {

	public static final Color appColor = new Color(0, 27, 185);

	public static boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(email);
		return mather.find();
	}

	public static String formatPhone(String phone) {
		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		Phonenumber.PhoneNumber phoneNumber = null;
		try {
			phoneNumber = phoneUtil.parse(phone, new Locale("es", "CO").getCountry());
		} catch (NumberParseException e) {
			e.printStackTrace();
		}
		return phoneUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
	}

	public static void sendEmail(String email) {
		String url = "https://mail.google.com/mail/?view=cm&fs=1&to=" + email;
		try {
			Desktop.getDesktop().browse(new URI(url));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public static File getFile(String fileStr) {
		File file = new File(fileStr);
		file.mkdirs();
		return file;
	}

	public static void openDirectory(String directory) {
		String url = Preferences.getRootDirectory() + directory;
		File file = new File(url);
		file.mkdirs();
		Runtime r = Runtime.getRuntime();
		try {
			r.exec("explorer.exe " + url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int calculateDV(String nit) {
		String[] nitStrings = nit.split("");
		int[] nitInt = new int[9];
		int i = 0;
		for (String c : nitStrings) {
			nitInt[i] = Integer.valueOf(c);
			i++;
		}
		int sum = (nitInt[0] * 41) + (nitInt[1] * 37) + (nitInt[2] * 29) + (nitInt[3] * 23) + (nitInt[4] * 19)
				+ (nitInt[5] * 17) + (nitInt[6] * 13) + (nitInt[7] * 7) + (nitInt[8] * 3);
		int dv = sum % 11;
		if (dv > 2) {
			dv = 11 - dv;
		}
		return dv;
	}

	public static boolean exportTable(String name, String[][] list) {
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		XSSFSheet xssfSheet = xssfWorkbook.createSheet(name);
		int rownum = 0;
		int totalRows = list.length;
		int totalColumns = list[0].length;
		for (int i = 0; i < totalRows; i++) {
			Row row = xssfSheet.createRow(rownum++);
			for (int j = 0; j < totalColumns; j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(list[i][j]);
				CellStyle cs = xssfWorkbook.createCellStyle();
				cs.setWrapText(true);
				cell.setCellStyle(cs);
			}
		}
		for (int j = 0; j < totalColumns; j++) {
			xssfSheet.autoSizeColumn(j);
		}
		try {
			JFileChooser jf = new JFileChooser();
			if (jf.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				String route = jf.getSelectedFile().getAbsolutePath();
				FileOutputStream out = new FileOutputStream(new File(route + ".xlsx"));
				xssfWorkbook.write(out);
				out.close();
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static String formatDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy");
		return format.format(date);
	}

	public static boolean isNumberOrNull(String idStr) {
		if (idStr.isEmpty())
			return true;
		if (NumbersUtil.isNumber(idStr)) {
			return true;
		}
		return false;
	}

	public static String formatNit(String iden) {
		String nit;
		int dvTest;
		switch (iden.length()) {
		case 9:
			if (NumbersUtil.isNumber(iden)) {
				int dv = Utils.calculateDV(iden);
				nit = StringsUtil.formatId(iden);
				return (nit + "-" + dv);
			}
		case 10:
			dvTest = Integer.valueOf(iden.substring(9, 10));
			nit = iden.substring(0, 9);
			if (NumbersUtil.isNumber(nit)) {
				if (dvTest == Utils.calculateDV(nit)) {
					return StringsUtil.formatId(nit) + "-" + dvTest;
				}
			}
		case 0:
			return "0";
		}
		return "";
	}

}
