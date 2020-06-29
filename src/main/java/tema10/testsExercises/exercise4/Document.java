package tema10.testsExercises.exercise4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.util.stream.Collectors.collectingAndThen;

public final class Document {
    private final String title;
    private final List<Page> pages;

    public Document(String title, List<Page> pages) {
        this.title = title;
        this.pages = Collections.unmodifiableList(new ArrayList<>(pages));
    }

    public List<Page> getPages() {
        return this.pages;
    }

    public String getTitle() {
        return this.title;
    }

    private Page appendFooter(Page original) {
        String footer = "Document: " + getTitle();
        return new Page(format("%s%n%s", original.getContent(), footer));
    }

    private Document copyWithPages(List<Page> newPages) {
        return new Document(title, newPages);
    }

    public Document copyWithFooter() {
        return getPages().stream()
            .map(page -> appendFooter(page))
            .collect(collectingAndThen(Collectors.<Page>toList(), pages -> copyWithPages(pages)));
    }

    public static final class Page {
        private final String content;

        public Page(String content) {
            this.content = content;
        }

        public String getContent() {
            return this.content;
        }
    }
}
