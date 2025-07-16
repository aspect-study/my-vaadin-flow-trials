package com.aspect.vaadin.study.views.common.ui.util.wrapper;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.VaadinIcon;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class LinkConfig {

    private final Class<? extends Component> viewClass;
    private final VaadinIcon icon;
    private final String routerId;
    private final String description;

}
