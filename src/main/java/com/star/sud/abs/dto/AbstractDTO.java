/**
 * 
 */
package com.star.sud.abs.dto;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.BeanUtils;

/**
 * @author Sudarshan
 *
 */
public abstract class AbstractDTO<T> implements Cloneable, Serializable {

	// Static Attributes
	///////////////////////
	private static final long serialVersionUID = -8681669830659535628L;

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
