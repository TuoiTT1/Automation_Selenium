package cores;

public class TestCase {
    private String tcid;
    private String title;
    private String result;
    private String note;

    public TestCase(String tcid, String title, String result, String note) {
        this.tcid = tcid;
        this.title = title;
        this.result = result;
        this.note = note;
    }

    public String getTcid() {
        return tcid;
    }

    public void setTcid(String tcid) {
        this.tcid = tcid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
