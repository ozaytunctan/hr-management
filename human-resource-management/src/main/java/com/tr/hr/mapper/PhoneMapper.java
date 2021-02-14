package com.tr.hr.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tr.hr.dto.PhoneDto;
import com.tr.hr.entity.Phone;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

	public PhoneDto phoneToPhoneDto(Phone phone);
	
	public List<PhoneDto> phonesToPhoneDtos(List<Phone> phone);

}
