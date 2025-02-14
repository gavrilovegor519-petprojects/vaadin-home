package ru.gavrilovegor519.vaadinhome.views.home;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Home")
@Route("")
public class HomeView extends Composite<VerticalLayout> {

    public HomeView() {
        H1 h1 = new H1();
        H2 h2 = new H2();
        H3 h3 = new H3();
        MultiSelectListBox textItems = new MultiSelectListBox();
        H3 h32 = new H3();
        MultiSelectListBox textItems2 = new MultiSelectListBox();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().setJustifyContentMode(JustifyContentMode.CENTER);
        getContent().setAlignItems(Alignment.CENTER);
        h1.setText("Егор Гаврилов");
        h1.setWidth("max-content");
        h2.setText("Java-разработчик");
        h2.setWidth("max-content");
        h3.setText("Мой стек:");
        h3.setWidth("max-content");
        textItems.setWidth("min-content");
        setMultiSelectListBoxSampleData(textItems);
        h32.setText("Ссылки:");
        h32.setWidth("max-content");
        textItems2.setWidth("min-content");
        setMultiSelectListBoxSampleData(textItems2);
        getContent().add(h1);
        getContent().add(h2);
        getContent().add(h3);
        getContent().add(textItems);
        getContent().add(h32);
        getContent().add(textItems2);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setMultiSelectListBoxSampleData(MultiSelectListBox multiSelectListBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        multiSelectListBox.setItems(sampleItems);
        multiSelectListBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
        multiSelectListBox.setItemEnabledProvider(item -> !Boolean.TRUE.equals(((SampleItem) item).disabled()));
    }
}
