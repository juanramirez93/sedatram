package com.sedatram.utils;

public class NumbersUtil {

	public static final int AUTH_FRAME_WIDTH = 400;
	public static final int AUTH_FRAME_HEIGHT = 150;
	public static final int AUTH_LENGTH = 10;
	public static final int MAIN_WIDTH = 400;
	public static final int MAIN_HEIGHT = 400;
	public static final int SEARCH_FIELD = 12;
	public static final int MAIN_CUSTOMER_WIDTH = 650;
	public static final int MAIN_CUSTOMER_HEIGHT = 500;
	public static final int NAT_CUSTOMER_HEIGHT = 450;
	public static final int NAT_CUSTOMER_WIDTH = 500;
	public static final int NAT_CUSTOMER_FIELD = 15;
	public static final int LEG_CUSTOMER_FIELD = 35;
	public static final int LEG_CUSTOMER_WIDTH = 600;
	public static final int LEG_CUSTOMER_HEIGHT = 500;
	public static final int VEHICLE_FIELDS = 10;
	public static final int MAIN_VEHICLE_WIDTH = 600;
	public static final int MAIN_VEHICLE_HEIGHT = 500;
	public static final int VEHICLE_WIDTH = 300;
	public static final int VEHICLE_HEIGHT = 650;
	public static final int DETAIL_VEHICLE_WIDTH = 450;
	public static final int DETAIL_VEHICLE_HEIGHT = 650;
	public static final int MAIN_OWNER_WIDTH = 400;
	public static final int MAIN_OWNER_HEIGHT = 250;
	public static final int OWNER_NAT_WIDTH = 400;
	public static final int OWNER_NAT_HEIGHT = 200;
	public static final int NAT_OWNER_WIDTH = 300;
	public static final int NAT_OWNER_HEIGHT = 250;
	public static final int LEG_OWNER_WIDTH = 600;
	public static final int LEG_OWNER_HEIGHT = 250;
	public static final int PASSWORD_FIELD = 10;
	public static final int PASSWORD_WIDTH = 400;
	public static final int PASSWORD_HEIGHT = 200;
	public static final int MAIN_FORMALITY_WIDTH = 650;
	public static final int MAIN_FORMALITY_HEIGHT = 400;
	public static final int FORMALITY_WIDTH = 500;
	public static final int FORMALITY_HEIGHT = 500;
	public static final int FORMALITY_FIELD = 10;
	public static final int MAIN_BUYER_WIDHT = 500;
	public static final int MAIN_BUYER_HEIGHT = 450;
	public static final int NAT_BUYER_WIDTH = 500;
	public static final int NAT_BUYER_HEIGHT = 500;
	public static final int NAT_BUYER_FIELDS = 10;

	public static boolean isNumber(String str) {
		try {
			Long.parseLong(str);
			return true;
		} catch (NumberFormatException exception) {
			return false;
		}
	}
}
