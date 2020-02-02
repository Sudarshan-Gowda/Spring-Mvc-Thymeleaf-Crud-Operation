package com.star.sud.abs.entity;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.BeanUtils;

public abstract class AbstractEntity<T> implements Cloneable, Serializable, Comparable<T> {

	// Static Attributes
	//////////////////////
	private static final long serialVersionUID = -6610117182157244761L;

	public abstract void init();

	public AbstractEntity() {
		init();
	}

	public void copyBeanProperties(Object target) {
		try {
			Collection<String> excludes = new ArrayList<String>();
			PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(this.getClass());
			PropertyDescriptor[] propertyDescriptorsTargets = BeanUtils.getPropertyDescriptors(target.getClass());
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
				String propName = propertyDescriptor.getName();
				boolean bPropNameFound = false;
				for (PropertyDescriptor propertyDescriptorTarget : propertyDescriptorsTargets) {
					String propNameTarget = propertyDescriptorTarget.getName();
					if (propName.equalsIgnoreCase(propNameTarget)) {
						bPropNameFound = true;
						break;
					}
				}
				if (!bPropNameFound) {
					excludes.add(propName);
				}
			}
			BeanUtils.copyProperties(this, target, excludes.toArray(new String[excludes.size()]));
		} catch (Exception ex) {
			throw ex;
		}
	}

}
