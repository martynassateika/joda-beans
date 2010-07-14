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
package org.joda.beans.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Code generator for a bean.
 * 
 * @author Stephen Colebourne
 */
class BeanGen {

    /** Start marker. */
    private static final String AUTOGENERATED_END = "\t//-------------------------- AUTOGENERATED END --------------------------";
    /** End marker. */
    private static final String AUTOGENERATED_START = "\t//------------------------- AUTOGENERATED START -------------------------";

    /** The content to process. */
    private final List<String> content;
    /** The simple name of the bean class. */
    private final String beanType;
    /** The bean type with generics removed. */
    private final String beanNoGenericsType;
    /** The start position of auto-generation. */
    private final int autoStartIndex;
    /** The end position of auto-generation. */
    private final int autoEndIndex;
    /** The region to insert into. */
    private List<String> insertRegion;
    /** The indent. */
    private final String indent;
    /** The prefix. */
    private final String prefix;

    /**
     * Constructor.
     * @param content  the content to process, not null
     * @param indent  the indent to use, not null
     * @param prefix  the prefix to use, not null
     */
    BeanGen(List<String> content, String indent, String prefix) {
        this.content = content;
        this.indent = indent;
        this.prefix = prefix;
        int extendsIndex = parseIsBean();
        if (extendsIndex >= 0) {
            this.beanType = parseBeanName(extendsIndex);
            this.beanNoGenericsType = makeNoGenerics(beanType);
            this.autoStartIndex = parseStartAutogen();
            this.autoEndIndex = parseEndAutogen();
            this.insertRegion = content.subList(autoStartIndex + 1, autoEndIndex);
        } else {
            this.beanType = null;
            this.beanNoGenericsType = null;
            this.autoStartIndex = -1;
            this.autoEndIndex = -1;
            this.insertRegion = null;
        }
    }

    private String makeNoGenerics(String beanType) {
        int pos = beanType.indexOf("<");
        return (pos < 0 ? beanType : beanType.substring(0, pos));
    }

    //-----------------------------------------------------------------------
    void process() {
        if (insertRegion != null) {
            List<PropertyGen> props = parseProperties();
            removeOld();
            generateMetaProperties(props);
            generateMetaBean();
            generatePropertyGet(props);
            generatePropertySet(props);
            generateGettersSetters(props);
            resolveIndents();
        }
    }

    private void resolveIndents() {
        for (ListIterator<String> it = content.listIterator(); it.hasNext(); ) {
            it.set(it.next().replace("\t", indent));
        }
    }

    //-----------------------------------------------------------------------
    private String parseBeanName(int extendsLine) {
        for (int index = extendsLine; index >= 0; index--) {
            String line = content.get(index).trim();
            int pos = line.indexOf(" class ");
            if (pos >= 0) {
                return line.substring(pos + 7).split(" ")[0];
            }
        }
        throw new RuntimeException("Unable to locate bean name");
    }

    private int parseIsBean() {
        for (int index = 0; index < content.size(); index++) {
            String line = content.get(index).trim();
            if (line.contains(" extends DirectBean ")) {
                return index;
            }
        }
        return -1;
    }

    private List<PropertyGen> parseProperties() {
        List<PropertyGen> props = new ArrayList<PropertyGen>();
        for (int index = 0; index < content.size(); index++) {
            String line = content.get(index).trim();
            if (line.startsWith("@PropertyDefinition")) {
                props.add(new PropertyGen(this, content, index));
            }
        }
        return props;
    }

    private int parseStartAutogen() {
        for (int index = 0; index < content.size(); index++) {
            String line = content.get(index).trim();
            if (line.contains(" AUTOGENERATED START ")) {
                content.set(index, AUTOGENERATED_START);
                return index;
            }
        }
        for (int index = content.size() - 1; index >= 0; index--) {
            String line = content.get(index).trim();
            if (line.equals("}")) {
                content.add(index, AUTOGENERATED_START);
                return index;
            }
            if (line.length() > 0) {
                break;
            }
        }
        throw new RuntimeException("Unable to locate start autogeneration point");
    }

    private int parseEndAutogen() {
        for (int index = autoStartIndex; index < content.size(); index++) {
            String line = content.get(index).trim();
            if (line.contains(" AUTOGENERATED END ")) {
                content.set(index, AUTOGENERATED_END);
                return index;
            }
        }
        content.add(autoStartIndex + 1, AUTOGENERATED_END);
        return autoStartIndex + 1;
    }

    private void removeOld() {
        insertRegion.clear();
    }

    //-----------------------------------------------------------------------
    private void generateSeparator() {
        insertRegion.add("\t//-----------------------------------------------------------------------");
    }

    private void generateMetaProperties(List<PropertyGen> props) {
        for (PropertyGen prop : props) {
            insertRegion.addAll(prop.generateMetaPropertyConstant());
        }
    }

    private void generateMetaBean() {
        insertRegion.add("\t/**");
        insertRegion.add("\t * The meta-bean for {@code " + beanNoGenericsType + "}.");
        insertRegion.add("\t */");
        insertRegion.add("\tprivate static final MetaBean META = ReflectiveMetaBean.of(" + beanNoGenericsType + ".class);");
        insertRegion.add("");
        generateSeparator();
        
        insertRegion.add("\t/**");
        insertRegion.add("\t * The meta-bean for {@code " + beanType + "}.");
        insertRegion.add("\t */");
        insertRegion.add("\tpublic static final MetaBean meta() {");
        insertRegion.add("\t\treturn META;");
        insertRegion.add("\t}");
        insertRegion.add("");
        
        insertRegion.add("\t@Override");
        insertRegion.add("\tpublic final MetaBean metaBean() {");
        insertRegion.add("\t\treturn META;");
        insertRegion.add("\t}");
        insertRegion.add("");
    }

    private void generateGettersSetters(List<PropertyGen> props) {
        for (PropertyGen prop : props) {
            generateSeparator();
            insertRegion.addAll(prop.generateGetter());
            insertRegion.addAll(prop.generateSetter());
            insertRegion.addAll(prop.generateProperty());
            insertRegion.addAll(prop.generateMetaProperty());
        }
    }

    private void generatePropertyGet(List<PropertyGen> props) {
        insertRegion.add("\t@Override");
        insertRegion.add("\tprotected Object propertyGet(String propertyName) {");
        insertRegion.add("\t\tswitch (propertyName.hashCode()) {");
        for (PropertyGen prop : props) {
            insertRegion.addAll(prop.generatePropertyGetCase());
        }
        insertRegion.add("\t\t}");
        insertRegion.add("\t\treturn super.propertyGet(propertyName);");
        insertRegion.add("\t}");
        insertRegion.add("");
    }

    private void generatePropertySet(List<PropertyGen> props) {
        insertRegion.add("\t@Override");
        boolean generics = false;
        for (PropertyGen prop : props) {
            generics |= prop.isGenericWritableProperty();
        }
        if (generics) {
            insertRegion.add("\t@SuppressWarnings(\"unchecked\")");
        }
        insertRegion.add("\tprotected void propertySet(String propertyName, Object newValue) {");
        insertRegion.add("\t\tswitch (propertyName.hashCode()) {");
        for (PropertyGen prop : props) {
            insertRegion.addAll(prop.generatePropertySetCase());
        }
        insertRegion.add("\t\t}");
        insertRegion.add("\t\tsuper.propertySet(propertyName, newValue);");
        insertRegion.add("\t}");
        insertRegion.add("");
    }

    //-----------------------------------------------------------------------
    boolean isBean() {
        return beanType != null;
    }

    String getBeanType() {
        return beanType;
    }

    String getBeanNoGenericsType() {
        return beanNoGenericsType;
    }

    boolean isGenericBean() {
        return getBeanType().equals(getBeanNoGenericsType()) == false;
    }

    String getBeanGeneric() {
        String beanGeneric = beanType.substring(beanNoGenericsType.length());
        beanGeneric = (beanGeneric.startsWith("<") ? beanGeneric.substring(1) : beanGeneric);
        return (beanGeneric.endsWith(">") ? beanGeneric.substring(0, beanGeneric.length() - 1) : beanGeneric);
    }

    String getFieldPrefix() {
        return prefix;
    }

}