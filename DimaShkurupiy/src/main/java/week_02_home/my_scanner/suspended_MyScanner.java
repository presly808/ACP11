package week_02_home.my_scanner;

import java.util.Map;

/**
 * Created by dima on 14.12.2015.
 */
interface Suspended_MyScanner {

// reading from stream
    public String nextString();

    public int nextInt();

    public char nextChar();

    public double nextDouble();

    public byte nextByte();

    public Pattern nextPattern();

// check stream for data
    public boolean hasNext();

    public boolean hasNextString();

    public boolean hasNextInt();

    public boolean hasNextChar();

    public boolean hasNextDouble();

    public boolean hasNextByte();

    public boolean hasNextPattern();

// close stream
    public void close();

// filters
    public void censure(String... fucks);

    public void specialSymbols(Tag... tags);

    public void charsetDecoder(CodePage cp);

}
// Patterns
class Pattern {

    private String regExp;

    public String getRegExp() {
        return regExp;
    }

    public void setRegExp(String regExp) {
        this.regExp = regExp;
    }
}

// tags
class Tag {

    private String tag;
    private String tagMeaning;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTagMeaning() {
        return tagMeaning;
    }

    public void setTagMeaning(String tagMeaning) {
        this.tagMeaning = tagMeaning;
    }
}

// CodePage for decoder
class CodePage {

    private Map<Byte,Character> cp;

    public Map<Byte, Character> getCp() {
        return cp;
    }

    public void setCp(Map<Byte, Character> cp) {
        this.cp = cp;
    }
}
