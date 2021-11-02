package com.jerin.oracle.certification.programmer;

public class EnumTry {

	public static void main(String[] args) {
		System.out.println(Weather.SUMMER.getCode());
		System.out.println(Weather.WINTER.getCode());

		System.out.println(Weather.SUMMER.getCode());
		System.out.println(Weather.SUMMER.getName());

		Weather.SUMMER.setName("New Name");
		System.out.println(Weather.SUMMER.getName());
		System.out.println(Weather.SUMMER.getString());
	}

}

enum Weather {

	SUMMER(1, "Summer") {
		@Override
		public String getString() {
			return "Enum Method for summer : " + this.getName();
		}
	},
	WINTER(2, "Winter") {
		@Override
		public String getString() {
			return "Enum Method for Winter : " + this.getName();
		}
	};

	private final int code;
	private String name;

	// Constructor should be private
	private Weather(int code, String name) {
		this.code = code;
		this.name = "Weather : " + name;
	}

	public int getCode() {
		return code;
	}

//	public void setCode(int code) {
//		this.code = code;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getString() {
		return "";
	};
}
