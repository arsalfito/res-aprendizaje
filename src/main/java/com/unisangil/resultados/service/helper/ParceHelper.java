package com.unisangil.resultados.service.helper;

import java.util.Date;

public class ParceHelper {

	public static String stringCell(Object object) {
        try {
            return object.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public static Long longCell(Object object) {
        try {
            return Long.parseLong(object.toString());
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer integerCell(Object object) {
        try {
            return Integer.parseInt(object.toString());
        } catch (Exception e) {
            return null;
        }
    }

    public static Date dateCell(Object object) {
        try {
            return (Date) object;
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Double doubleCell(Object object) {
        try {
            return Double.parseDouble(object.toString());
        } catch (Exception e) {
            return null;
        }
    }
}
