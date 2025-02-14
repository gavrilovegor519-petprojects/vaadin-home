package ru.gavrilovegor519.vaadinhome.views.home;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Егор Гаврилов - хоумпейдж")
@Route("")
public class HomeView extends Composite<VerticalLayout> {
    private final H1 h1 = new H1();
    private final H2 h2 = new H2();
    private final H3 h3 = new H3();
    private final UnorderedList textItems = new UnorderedList();
    private final H3 h32 = new H3();
    private final UnorderedList textItems2 = new UnorderedList();

    public HomeView() {
        getContent().setWidthFull();
        getContent().setHeightFull();
        getContent().setJustifyContentMode(JustifyContentMode.CENTER);
        getContent().setAlignItems(Alignment.CENTER);

        VerticalLayout content = new VerticalLayout();
        content.setMaxWidth("800px");
        content.setAlignItems(Alignment.CENTER);

        VerticalLayout content2 = new VerticalLayout();

        setName();
        setProfession();
        setSkillsPartSettings();
        setLinksPartSettings();

        content2.add(h3, textItems, h32, textItems2);
        content.add(h1, h2, content2);
        getContent().add(content);
    }

    private void setName() {
        h1.setText("Егор Гаврилов");
        h1.setWidth("max-content");
    }

    private void setProfession() {
        h2.setText("Java Developer");
        h2.setWidth("max-content");
    }

    private List<String> getSkills() {
        List<String> skills = new ArrayList<>();
        skills.add("Java 17");
        skills.add("Spring 5/6 (Web, Data JPA, Security)");
        skills.add("JPA, SQL");
        skills.add("Linux, Docker");
        return skills;
    }

    private List<Anchor> getLinks() {
        List<Anchor> links = new ArrayList<>();
        links.add(new Anchor("https://github.com/gavrilovegor519", "GitHub"));
        links.add(new Anchor("https://www.youtube.com/@gavrilovegor519", "YouTube"));
        links.add(new Anchor("https://habr.com/ru/users/gavrilovegor519/", "Habr"));
        links.add(new Anchor("https://t.me/gavrilovegor519", "Telegram"));
        return links;
    }

    private void setSkillsPartSettings() {
        h3.setText("Мой стек:");

        for (String skill : getSkills()) {
            ListItem item = new ListItem(skill);
            item.setWhiteSpace(HasText.WhiteSpace.PRE_WRAP);
            textItems.add(item);
        }
    }

    private void setLinksPartSettings() {
        h32.setText("Ссылки:");

        for (Anchor link : getLinks()) {
            ListItem item = new ListItem(link);
            item.setWhiteSpace(HasText.WhiteSpace.PRE_WRAP);
            textItems2.add(item);
        }
    }
}
