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
    private final H1 myName = new H1();
    private final H2 profession = new H2();
    private final H3 skillsPartHeading = new H3();
    private final UnorderedList skills = new UnorderedList();
    private final H3 linksPartHeading = new H3();
    private final UnorderedList links = new UnorderedList();

    private final Paragraph fidoNetPart = new Paragraph("""
                                                   Также я являюсь самым молодым сисопом в
                                                   Фидонете на сегодняшний день - 2:5015/519.
                                                   """);

    private final VerticalLayout content = new VerticalLayout();
    private final VerticalLayout content2 = new VerticalLayout();

    public HomeView() {
        setName();
        setProfession();
        setSkillsPartSettings();
        setLinksPartSettings();
        setupLayout();
    }

    private void setName() {
        myName.setText("Егор Гаврилов");
        myName.setWidth("max-content");
    }

    private void setProfession() {
        profession.setText("Java Developer");
        profession.setWidth("max-content");
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
        skillsPartHeading.setText("Мой стек:");

        for (String skill : getSkills()) {
            ListItem item = new ListItem(skill);
            item.setWhiteSpace(HasText.WhiteSpace.PRE_WRAP);
            skills.add(item);
        }
    }

    private void setLinksPartSettings() {
        linksPartHeading.setText("Ссылки:");

        for (Anchor link : getLinks()) {
            ListItem item = new ListItem(link);
            item.setWhiteSpace(HasText.WhiteSpace.PRE_WRAP);
            links.add(item);
        }
    }

    private void setupLayout() {
        getContent().setWidthFull();
        getContent().setMinHeight("100vh");
        getContent().setJustifyContentMode(JustifyContentMode.CENTER);
        getContent().setAlignItems(Alignment.CENTER);

        content.setMaxWidth("800px");
        content.setAlignItems(Alignment.CENTER);

        content2.add(skillsPartHeading, skills, linksPartHeading, links, fidoNetPart);
        content.add(myName, profession, content2);
        getContent().add(content);
    }
}
