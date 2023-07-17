package com.demo.heroes.common;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class CommonUtils {
	public static void copyNonNullProperties(Object source, Object destination) {
		// getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
		Set<String> emptyNames = new HashSet<String>();
		for (java.beans.PropertyDescriptor pd : pds) {
			// check if value of this property is null add name
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null || srcValue.toString().contains("*")) {
				emptyNames.add(pd.getName());
			}
		}
		String[] result = new String[emptyNames.size()];
		String[] ignoreProperties = emptyNames.toArray(result);
		BeanUtils.copyProperties(source, destination, ignoreProperties);
	}
}
