package tema3.library;

public class Albums extends Book {
    private String paperQuality;

    public String getPaperQuality() {
        return paperQuality;
    }

    public void setPaperQuality(String paperQuality) {
        this.paperQuality = paperQuality;
    }
    public String toStringList() {
        return "album, " + this.getName() + ", " + this.getNumberOfPages() + ", " + this.getPaperQuality();
    }
}
