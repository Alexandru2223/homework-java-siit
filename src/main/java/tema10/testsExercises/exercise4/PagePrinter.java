package tema10.testsExercises.exercise4;

import tema10.testsExercises.exercise4.Document.Page;

import static java.lang.String.format;

public final class PagePrinter {

    private final String pageBreak;

    public PagePrinter(String pageBreak) {
        this.pageBreak = pageBreak;
    }

    public String printTitlePage(Document document) {
        return format(
                "%s%n" +
                "%s%n", document.getTitle(), pageBreak);
    }

    public String printPage(Page page) {
        return format(
                "%s%n" +
                "%s%n", page.getContent(), pageBreak);
    }
}
