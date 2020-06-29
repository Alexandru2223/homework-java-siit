package tema10.testsExercises.exercise4;

import java.util.Arrays;
import java.util.List;

import tema10.testsExercises.exercise4.Document.Page;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Documents {

    /**
     * Return the titles from a list of documents.
     */
    public static List<String> titlesOf(Document... documents) {
        return Arrays.stream(documents)
                .map(Document::getTitle)
                .collect(toList());
    }

    public static Integer characterCount(Page page) {
        return page.getContent().length();
    }

    public static List<Integer> pageCharacterCounts(Document document) {
        return document.getPages().stream()
                .map(Documents::characterCount)
                .collect(toList());
    }

    public static String print(Document document, PagePrinter pagePrinter) {
        StringBuilder output = new StringBuilder();

        output.append(pagePrinter.printTitlePage(document));
        document.getPages().stream()
                .map(pagePrinter::printPage)
                .forEach(output::append);

        return output.toString();
    }

    public static Document translate(Document document, Translator translator) {
        return document.getPages().stream()
                .map(Page::getContent)
                .map(translator::translate)
                .map(Page::new)
                .collect(collectingAndThen(toList(),
                                           pages -> new Document(translator.translate(document.getTitle()), pages)));
    }
}
