/*
 *  Copyright 2001-2011 Stephen Colebourne
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

import org.joda.beans.impl.BasicBeanBuilder;
import org.joda.beans.impl.direct.DirectBean;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

/**
 * Mock pair, used for testing.
 * 
 * @author Stephen Colebourne
 */
@BeanDefinition
public class Pair extends DirectBean {

    /**
     * The first value.
     */
    @PropertyDefinition
    private Object first;
    /**
     * The second value.
     */
    @PropertyDefinition
    private Object second;

    //------------------------- AUTOGENERATED START -------------------------
    ///CLOVER:OFF
    /**
     * The meta-bean for {@code Pair}.
     * @return the meta-bean, not null
     */
    public static Pair.Meta meta() {
        return Pair.Meta.INSTANCE;
    }

    @Override
    public Pair.Meta metaBean() {
        return Pair.Meta.INSTANCE;
    }

    @Override
    protected Object propertyGet(String propertyName) {
        switch (propertyName.hashCode()) {
            case 97440432:  // first
                return getFirst();
            case -906279820:  // second
                return getSecond();
        }
        return super.propertyGet(propertyName);
    }

    @Override
    protected void propertySet(String propertyName, Object newValue) {
        switch (propertyName.hashCode()) {
            case 97440432:  // first
                setFirst((Object) newValue);
                return;
            case -906279820:  // second
                setSecond((Object) newValue);
                return;
        }
        super.propertySet(propertyName, newValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            Pair other = (Pair) obj;
            return JodaBeanUtils.equal(getFirst(), other.getFirst()) &&
                    JodaBeanUtils.equal(getSecond(), other.getSecond());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash += hash * 31 + JodaBeanUtils.hashCode(getFirst());
        hash += hash * 31 + JodaBeanUtils.hashCode(getSecond());
        return hash;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the first value.
     * @return the value of the property
     */
    public Object getFirst() {
        return first;
    }

    /**
     * Sets the first value.
     * @param first  the new value of the property
     */
    public void setFirst(Object first) {
        this.first = first;
    }

    /**
     * Gets the the {@code first} property.
     * @return the property, not null
     */
    public final Property<Object> first() {
        return metaBean().first().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the second value.
     * @return the value of the property
     */
    public Object getSecond() {
        return second;
    }

    /**
     * Sets the second value.
     * @param second  the new value of the property
     */
    public void setSecond(Object second) {
        this.second = second;
    }

    /**
     * Gets the the {@code second} property.
     * @return the property, not null
     */
    public final Property<Object> second() {
        return metaBean().second().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code Pair}.
     */
    public static class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code first} property.
         */
        private final MetaProperty<Object> first = DirectMetaProperty.ofReadWrite(
                this, "first", Pair.class, Object.class);
        /**
         * The meta-property for the {@code second} property.
         */
        private final MetaProperty<Object> second = DirectMetaProperty.ofReadWrite(
                this, "second", Pair.class, Object.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<Object>> map = new DirectMetaPropertyMap(
                this, null,
                "first",
                "second");

        /**
         * Restricted constructor.
         */
        protected Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 97440432:  // first
                    return first;
                case -906279820:  // second
                    return second;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public BeanBuilder<? extends Pair> builder() {
            return new BasicBeanBuilder<Pair>(new Pair());
        }

        @Override
        public Class<? extends Pair> beanType() {
            return Pair.class;
        }

        @Override
        public Map<String, MetaProperty<Object>> metaPropertyMap() {
            return map;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code first} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<Object> first() {
            return first;
        }

        /**
         * The meta-property for the {@code second} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<Object> second() {
            return second;
        }

    }

    ///CLOVER:ON
    //-------------------------- AUTOGENERATED END --------------------------
}
