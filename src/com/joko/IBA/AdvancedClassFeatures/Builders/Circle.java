package com.joko.IBA.AdvancedClassFeatures.Builders;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Joko on 01.12.2016.
 */
public class Circle extends Shape{

    int radius;

    public Circle(int radius){
        super(5, 5, 5, "red");
        this.radius = radius;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(1, 3, this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(obj, this);
    }
}
