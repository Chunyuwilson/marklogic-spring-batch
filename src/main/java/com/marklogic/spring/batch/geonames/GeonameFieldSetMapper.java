package com.marklogic.spring.batch.geonames;

import java.util.Arrays;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.marklogic.spring.batch.geonames.data.Geoname;

public class GeonameFieldSetMapper implements FieldSetMapper<Geoname>{

	@Override
	public Geoname mapFieldSet(FieldSet fieldSet) throws BindException {
		Geoname geo = new Geoname();
		geo.setId(fieldSet.readString(0));
		geo.setName(fieldSet.readString(1));
		geo.setAsciiName(fieldSet.readString(2));
		geo.setAlternateNames(Arrays.asList(fieldSet.readString(3).split(",")));		
		geo.setLatitude(fieldSet.readFloat(4));
		geo.setLongitude(fieldSet.readFloat(5));
		geo.setFeatureClass(fieldSet.readString(6));
		geo.setFeatureCode(fieldSet.readString(7));
		geo.setCountryCode(fieldSet.readString(8));
		geo.setAdmin1Code(fieldSet.readString(10));
		geo.setAdmin2Code(fieldSet.readString(11));
		return geo;
	}

}