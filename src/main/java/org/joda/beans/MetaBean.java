/*
 *  Copyright 2001-2010 Stephen Colebourne
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.joda.beans;

import java.util.Map;
import java.util.NoSuchElementException;

/**
 * A meta-bean, defining those aspects of a bean which are not specific
 * to a particular instance, such as the type and set of meta-properties.
 * 
 * @param <B>  the type of the bean
 * @author Stephen Colebourne
 */
public interface MetaBean<B> {

    /**
     * Creates a new instance of the bean represented by this meta bean.
     * 
     * @return the created bean, never null
     */
    Bean<B> createBean();

    /**
     * Creates a map of properties for the specified bean.
     * 
     * @param bean  the bean to create the map for, not null
     * @return the created property map, never null
     */
    PropertyMap<B> createPropertyMap(Bean<B> bean);

    //-----------------------------------------------------------------------
    /**
     * Gets the bean name, which is normally the fully qualified class name of the bean.
     * 
     * @return the name of the bean, never null
     */
    String name();

    /**
     * Get the type of the bean represented as a {@code Class}.
     * 
     * @return the type of the bean, never null
     */
    Class<B> beanClass();

    //-----------------------------------------------------------------------
    /**
     * Checks if a property exists.
     * 
     * @param propertyName  the property name to check, null returns false
     * @return true if the property exists
     */
    boolean metaPropertyExists(String propertyName);

    /**
     * Gets a meta-property by name.
     * 
     * @param propertyName  the property name to retrieve, null throws NoSuchElementException
     * @return the meta property, never null
     * @throws NoSuchElementException if the property name is invalid
     */
    MetaProperty<B, Object> metaProperty(String propertyName);

    /**
     * Gets the map of meta-properties, keyed by property name.
     * 
     * @return the unmodifiable map of meta property objects, never null
     */
    Map<String, MetaProperty<B, Object>> metaPropertyMap();

}
