/*
 *  Copyright 2001-present Stephen Colebourne
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
package org.joda.beans.gen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Map;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.DerivedProperty;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.google.common.base.Optional;
import java.util.Set;
import org.joda.beans.Property;

/**
 * Mock minimal bean, used for testing.
 * 
 * @author Stephen Colebourne
 */
@BeanDefinition(style = "minimal")
public final class MinimalMutable implements Bean, Serializable {

    /**
     * The number.
     */
    @PropertyDefinition
    private int number;
    /**
     * The number.
     */
    @PropertyDefinition
    private boolean flag;
    /**
     * The street.
     */
    @PropertyDefinition(validate = "notNull", get = "field")
    private String street;
    /**
     * The text.
     */
    @PropertyDefinition(get = "optionalGuava")
    private String town;
    /**
     * The city.
     */
    @PropertyDefinition(validate = "notNull")
    private String city;
    /**
     * The list.
     */
    @PropertyDefinition(validate = "notNull")
    private final List<String> list = new ArrayList<String>();
    /**
     * The currency.
     */
    @PropertyDefinition(get = "optionalGuava")
    private Currency currency;

    //-----------------------------------------------------------------------
    // manual getter with a different name
    public String getStreetName() {
        return street;
    }

    // derived
    @DerivedProperty
    public String getAddress() {
        return number + " " + street + " " + city;
    }

    //------------------------- AUTOGENERATED START -------------------------
    ///CLOVER:OFF
    /**
     * The meta-bean for {@code MinimalMutable}.
     * @return the meta-bean, not null
     */
    public static MinimalMutable.Meta meta() {
        return MinimalMutable.Meta.INSTANCE;
    }

    static {
        JodaBeanUtils.registerMetaBean(MinimalMutable.Meta.INSTANCE);
    }

    /**
     * The serialization version id.
     */
    private static final long serialVersionUID = 1L;

    @Override
    public MinimalMutable.Meta metaBean() {
        return MinimalMutable.Meta.INSTANCE;
    }

    @Override
    public <R> Property<R> property(String propertyName) {
        return metaBean().<R>metaProperty(propertyName).createProperty(this);
    }

    @Override
    public Set<String> propertyNames() {
        return metaBean().metaPropertyMap().keySet();
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the number.
     * @return the value of the property
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the number.
     * @param number  the new value of the property
     */
    public void setNumber(int number) {
        this.number = number;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the number.
     * @return the value of the property
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * Sets the number.
     * @param flag  the new value of the property
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the street.
     * @param street  the new value of the property, not null
     */
    public void setStreet(String street) {
        JodaBeanUtils.notNull(street, "street");
        this.street = street;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the text.
     * @return the optional value of the property, not null
     */
    public Optional<String> getTown() {
        return Optional.fromNullable(town);
    }

    /**
     * Sets the text.
     * @param town  the new value of the property
     */
    public void setTown(String town) {
        this.town = town;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the city.
     * @return the value of the property, not null
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     * @param city  the new value of the property, not null
     */
    public void setCity(String city) {
        JodaBeanUtils.notNull(city, "city");
        this.city = city;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the list.
     * @return the value of the property, not null
     */
    public List<String> getList() {
        return list;
    }

    /**
     * Sets the list.
     * @param list  the new value of the property, not null
     */
    public void setList(List<String> list) {
        JodaBeanUtils.notNull(list, "list");
        this.list.clear();
        this.list.addAll(list);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the currency.
     * @return the optional value of the property, not null
     */
    public Optional<Currency> getCurrency() {
        return Optional.fromNullable(currency);
    }

    /**
     * Sets the currency.
     * @param currency  the new value of the property
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    //-----------------------------------------------------------------------
    @Override
    public MinimalMutable clone() {
        return JodaBeanUtils.cloneAlways(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            MinimalMutable other = (MinimalMutable) obj;
            return (getNumber() == other.getNumber()) &&
                    (isFlag() == other.isFlag()) &&
                    JodaBeanUtils.equal(street, other.street) &&
                    JodaBeanUtils.equal(town, other.town) &&
                    JodaBeanUtils.equal(getCity(), other.getCity()) &&
                    JodaBeanUtils.equal(getList(), other.getList()) &&
                    JodaBeanUtils.equal(currency, other.currency);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(getNumber());
        hash = hash * 31 + JodaBeanUtils.hashCode(isFlag());
        hash = hash * 31 + JodaBeanUtils.hashCode(street);
        hash = hash * 31 + JodaBeanUtils.hashCode(town);
        hash = hash * 31 + JodaBeanUtils.hashCode(getCity());
        hash = hash * 31 + JodaBeanUtils.hashCode(getList());
        hash = hash * 31 + JodaBeanUtils.hashCode(currency);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(256);
        buf.append("MinimalMutable{");
        buf.append("number").append('=').append(getNumber()).append(',').append(' ');
        buf.append("flag").append('=').append(isFlag()).append(',').append(' ');
        buf.append("street").append('=').append(street).append(',').append(' ');
        buf.append("town").append('=').append(town).append(',').append(' ');
        buf.append("city").append('=').append(getCity()).append(',').append(' ');
        buf.append("list").append('=').append(getList()).append(',').append(' ');
        buf.append("currency").append('=').append(JodaBeanUtils.toString(currency));
        buf.append('}');
        return buf.toString();
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code MinimalMutable}.
     */
    public static final class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code number} property.
         */
        private final MetaProperty<Integer> number = DirectMetaProperty.ofReadWrite(
                this, "number", MinimalMutable.class, Integer.TYPE);
        /**
         * The meta-property for the {@code flag} property.
         */
        private final MetaProperty<Boolean> flag = DirectMetaProperty.ofReadWrite(
                this, "flag", MinimalMutable.class, Boolean.TYPE);
        /**
         * The meta-property for the {@code street} property.
         */
        private final MetaProperty<String> street = DirectMetaProperty.ofReadWrite(
                this, "street", MinimalMutable.class, String.class);
        /**
         * The meta-property for the {@code town} property.
         */
        private final MetaProperty<String> town = DirectMetaProperty.ofReadWrite(
                this, "town", MinimalMutable.class, String.class);
        /**
         * The meta-property for the {@code city} property.
         */
        private final MetaProperty<String> city = DirectMetaProperty.ofReadWrite(
                this, "city", MinimalMutable.class, String.class);
        /**
         * The meta-property for the {@code list} property.
         */
        @SuppressWarnings({"unchecked", "rawtypes" })
        private final MetaProperty<List<String>> list = DirectMetaProperty.ofReadWrite(
                this, "list", MinimalMutable.class, (Class) List.class);
        /**
         * The meta-property for the {@code currency} property.
         */
        private final MetaProperty<Currency> currency = DirectMetaProperty.ofReadWrite(
                this, "currency", MinimalMutable.class, Currency.class);
        /**
         * The meta-property for the {@code address} property.
         */
        private final MetaProperty<String> address = DirectMetaProperty.ofDerived(
                this, "address", MinimalMutable.class, String.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "number",
                "flag",
                "street",
                "town",
                "city",
                "list",
                "currency",
                "address");

        /**
         * Restricted constructor.
         */
        private Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case -1034364087:  // number
                    return number;
                case 3145580:  // flag
                    return flag;
                case -891990013:  // street
                    return street;
                case 3566226:  // town
                    return town;
                case 3053931:  // city
                    return city;
                case 3322014:  // list
                    return list;
                case 575402001:  // currency
                    return currency;
                case -1147692044:  // address
                    return address;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public BeanBuilder<? extends MinimalMutable> builder() {
            return new DirectBeanBuilder<MinimalMutable>(new MinimalMutable());
        }

        @Override
        public Class<? extends MinimalMutable> beanType() {
            return MinimalMutable.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case -1034364087:  // number
                    return ((MinimalMutable) bean).getNumber();
                case 3145580:  // flag
                    return ((MinimalMutable) bean).isFlag();
                case -891990013:  // street
                    return ((MinimalMutable) bean).street;
                case 3566226:  // town
                    return ((MinimalMutable) bean).town;
                case 3053931:  // city
                    return ((MinimalMutable) bean).getCity();
                case 3322014:  // list
                    return ((MinimalMutable) bean).getList();
                case 575402001:  // currency
                    return ((MinimalMutable) bean).currency;
                case -1147692044:  // address
                    return ((MinimalMutable) bean).getAddress();
            }
            return super.propertyGet(bean, propertyName, quiet);
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
            switch (propertyName.hashCode()) {
                case -1034364087:  // number
                    ((MinimalMutable) bean).setNumber((Integer) newValue);
                    return;
                case 3145580:  // flag
                    ((MinimalMutable) bean).setFlag((Boolean) newValue);
                    return;
                case -891990013:  // street
                    ((MinimalMutable) bean).setStreet((String) newValue);
                    return;
                case 3566226:  // town
                    ((MinimalMutable) bean).setTown((String) newValue);
                    return;
                case 3053931:  // city
                    ((MinimalMutable) bean).setCity((String) newValue);
                    return;
                case 3322014:  // list
                    ((MinimalMutable) bean).setList((List<String>) newValue);
                    return;
                case 575402001:  // currency
                    ((MinimalMutable) bean).setCurrency((Currency) newValue);
                    return;
                case -1147692044:  // address
                    if (quiet) {
                        return;
                    }
                    throw new UnsupportedOperationException("Property cannot be written: address");
            }
            super.propertySet(bean, propertyName, newValue, quiet);
        }

        @Override
        protected void validate(Bean bean) {
            JodaBeanUtils.notNull(((MinimalMutable) bean).street, "street");
            JodaBeanUtils.notNull(((MinimalMutable) bean).city, "city");
            JodaBeanUtils.notNull(((MinimalMutable) bean).list, "list");
        }

    }

    ///CLOVER:ON
    //-------------------------- AUTOGENERATED END --------------------------
}
