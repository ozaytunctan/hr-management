package com.tr.hr.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PositionLevel {

	LEVEL_1(1), LEVEL_2(2), LEVEL_3(3), LEVEL_4(4), LEVEL_5(5);

	private Integer level;
	
	public static PositionLevel DEFAULT=PositionLevel.LEVEL_1;

	PositionLevel(Integer level) {
		this.setLevel(level);
	}

	public static PositionLevel valueOf(Integer level) {
		for (PositionLevel positionLevel : values()) {
			if (positionLevel.level.equals(level))
				return positionLevel;
		}

		throw new IllegalArgumentException("");
	}

	@JsonValue
	public Integer getLevel() {
		return level;
	}

	@JsonCreator
	public void setLevel(Integer level) {
		this.level = level;
	}

}
