package com.vilsale.common.jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class IgnoreField {

    @JsonIgnore
    public abstract Integer getVersion();

    @JsonIgnore
    public abstract String getTs();

}
