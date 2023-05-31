package com.demo.test.easypoi.data;

import java.util.Map;

/**
 * @author: lxw
 * @date: 2023-05-29  13:50
 */
public class GraphNode {
    protected String id;

    protected String[] types;

    protected Map<String, Object> props;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String getType() {
        return types == null ? null : types[0];
    }

    public void setType(String type) {
        this.types = new String[]{type};
    }

    public Map<String, Object> getProps() {
        return props;
    }

    public void setProps(Map<String, Object> props) {
        this.props = props;
    }
}
