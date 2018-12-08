package problemDomain;

public class Word implements Comparable<Word> {
    private String lineNum;
    private String word;
    private String fileName;

    public Word() {
    }

    public Word(String word)
    {
        this.word = word;
        this.lineNum = "";
        this.fileName = "";
    }

    public Word(String lineNum,String word, String fileName) {
        this.lineNum = lineNum;
        this.word = word;
        this.fileName = fileName;
    }

    public String getLineNum() {
        return word;
    }

    public void setLineNum(String lineNum) {
        this.lineNum = lineNum;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public int compareTo(Word o) {
        return o.word.compareTo(this.word);
    }

    @Override
    public String toString() {
        return "Word{" +
                "lineNum='" + lineNum + '\'' +
                ", word='" + word + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
