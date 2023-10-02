package com.example.test.azeriqaz_smartcart;

import java.io.Serializable;
import org.xml.sax.Attributes;

public class XML_Data implements Serializable {
    private static final long serialVersionUID = -6692966615379722919L;
    private String name;
    private String value;
    private XML_Data[] childs;
    private XML_Data parent;
    private int childcount;
    private MyAttribute[] attributes;
    private boolean isEmpty;
    private static XML_Data emptyInstanse = new XML_Data(0);

    public XML_Data() {
        this(16);
    }

    public XML_Data(int i) {
        this.name = "";
        this.value = "";
        this.attributes = new MyAttribute[0];
        this.isEmpty = true;
        this.childs = new XML_Data[i];
        this.childcount = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.isEmpty = false;
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public String getValueUtf8() {
        try {
            return this.value == null ? null : new String(this.value.getBytes(), "UTF-8");
        } catch (Exception var2) {
            return this.value;
        }
    }

    public void setValue(String value) {
        this.isEmpty = false;
        this.value = value;
    }

    public void AddChilds(XML_Data child) {
        this.isEmpty = false;
        child.setParent(this);
        if (this.childs.length <= this.childcount) {
            this.extendArray(this.childcount * 2);
        }

        this.childs[this.childcount++] = child;
        this.optimize();
    }

    public XML_Data[] getChilds() {
        return this.childs;
    }

    public XML_Data[] getChildsAsArray(String name) {
        XML_Data[] res = new XML_Data[this.getChildCount(name)];
        int id = 0;

        for(int i = 0; i < this.childcount; ++i) {
            if (this.childs[i].name.equalsIgnoreCase(name)) {
                res[id++] = this.childs[i];
            }
        }

        return res;
    }

    public int getChildCount(String name) {
        int count = 0;

        for(int i = 0; i < this.childcount; ++i) {
            if (this.childs[i].name.equalsIgnoreCase(name)) {
                ++count;
            }
        }

        return count;
    }

    public XML_Data getChildByName(String name) {
        return this.getChildByName(name, 1);
    }

    public XML_Data getChildNodeSequense(String name) {
        XML_Data res = this;
        String[] names = name.split("\\.");

        for(int i = 0; i < names.length; ++i) {
            res = res.getChildByName(names[i]);
        }

        return res;
    }

    public XML_Data getChildByNameFromZero(String name, int id) {
        return this.getChildByName(name, id + 1);
    }

    /** @deprecated */
    @Deprecated
    public XML_Data getChildByName(String name, int id) {
        int findid = id;

        for(int i = 0; i < this.childcount; ++i) {
            if (this.childs[i].name.equalsIgnoreCase(name) && findid-- == 1) {
                return this.childs[i];
            }
        }

        return emptyInstanse;
    }

    public boolean hasChildByName(String name, int id) {
        int findid = id;

        for(int i = 0; i < this.childcount; ++i) {
            if (this.childs[i].name.equalsIgnoreCase(name) && findid-- == 1) {
                return true;
            }
        }

        return false;
    }

    private void extendArray(int i) {
        XML_Data[] tmp = new XML_Data[i];
        System.arraycopy(this.childs, 0, tmp, 0, this.childcount);
        this.childs = tmp;
    }

    public void optimize() {
        XML_Data[] tmp = new XML_Data[this.childcount];
        System.arraycopy(this.childs, 0, tmp, 0, this.childcount);
        this.childs = tmp;
    }

    public XML_Data getParent() {
        return this.parent;
    }

    public void setParent(XML_Data parent) {
        this.isEmpty = false;
        this.parent = parent;
    }

    public int getChildCount() {
        return this.childcount;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.toString(sb);
        return sb.toString();
    }

    private void toString(StringBuilder sb) {
        sb.append("<" + this.name);

        int i;
        for(i = 0; i < this.attributes.length; ++i) {
            sb.append(" ").append(this.attributes[i].getName()).append("=\"").append(this.attributes[i].getValue()).append("\"");
        }

        if (this.value.equals("") && this.childs.length == 0) {
            sb.append(" />");
        } else {
            sb.append(">");
            if (this.childcount != 0) {
                for(i = 0; i < this.childcount; ++i) {
                    this.childs[i].toString(sb);
                }
            } else {
                sb.append(this.value);
            }

            sb.append("</").append(this.name).append(">");
        }
    }

    public MyAttribute[] getAttributes() {
        return this.attributes;
    }

    public String getAttributeByName(String name) {
        for(int i = 0; i < this.attributes.length; ++i) {
            if (this.attributes[i].getName().equals(name)) {
                return this.attributes[i].getValue();
            }
        }

        return null;
    }

    public void setAttributes(Attributes a) {
        this.attributes = new MyAttribute[a.getLength()];

        for(int i = 0; i < this.attributes.length; ++i) {
            this.attributes[i] = MyAttribute.createAttribute(a.getQName(i), a.getValue(a.getQName(i)));
        }

    }

    public void setAttributes(MyAttribute[] attributes) {
        this.attributes = attributes;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }
}
