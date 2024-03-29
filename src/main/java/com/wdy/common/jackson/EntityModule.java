package com.wdy.common.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.wdy.common.base.BaseEntity;
import org.springframework.stereotype.Component;

@Component
public class EntityModule extends SimpleModule {

    private static final long serialVersionUID = 1L;

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(BaseEntity.class, IgnoreField.class);
    }

}
