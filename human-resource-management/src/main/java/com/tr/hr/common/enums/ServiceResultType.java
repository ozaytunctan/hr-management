package com.tr.hr.common.enums;

public enum ServiceResultType {

	SUCCESS(200), ERROR(500);

	private Integer statusCode;

	private ServiceResultType(Integer code) {
		this.statusCode = code;
	}

	public static ServiceResultType valueOf(Integer code) throws IllegalArgumentException {
		for (ServiceResultType resultType : values()) {
			if (resultType.statusCode.equals(code))
				return resultType;
		}

		throw new IllegalArgumentException("Invalid parameter status Code:" + code);
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

}
