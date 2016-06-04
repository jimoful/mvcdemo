package com.fw.util;

@SuppressWarnings("serial")
public class MyException extends Exception {

	public MyException() {
	}

    public static void main(String[] args) {
        char[] chs=new char[]{'我','门'};
        System.out.println(String.copyValueOf(chs));
        String s="__string   s  ";
        System.out.print(s.trim());
        System.out.println("**");
        System.out.println(String.valueOf(true));
        System.out.println(s.replace(" ","*"));
    }

    public MyException(String message) {
		super(message);
	}

}
