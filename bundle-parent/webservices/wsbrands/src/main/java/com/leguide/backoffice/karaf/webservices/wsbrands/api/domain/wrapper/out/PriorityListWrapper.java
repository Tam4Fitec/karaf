package com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "priorityList")
@XmlType(propOrder = { "priorityList" })
public final class PriorityListWrapper implements Serializable {

    private static final long serialVersionUID = -1937844535057250763L;

    private List<Integer> priorityList = new ArrayList<Integer>();

    @XmlElement(name = "priorityList")
    public List<Integer> getPriorityList() {
        return this.priorityList;
    }

    public void setPriorityList(List<Integer> priorityList) {
        this.priorityList = priorityList;
    }
}
