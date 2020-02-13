package com.castmart.ds;

public class StringCreatorImpl implements StringCreator {

    char[] charArray = null;
    public StringCreatorImpl() { }

    @Override
    public StringCreator append(String string) {
        if (string != null) {
            if (charArray == null) {
                charArray = string.toCharArray();
            } else {
                resizeAndAppend(string);
            }
        }
        return this;
    }

    private void resizeAndAppend(String string) {
        char[] resized = new char[charArray.length + string.length()];
        for (int i = 0, j = 0; i < resized.length; i++) {
            if (i < charArray.length) {
                resized[i] = charArray[i];
            } else {
                resized[i] = string.charAt(j++);
            }
        }
        this.charArray = resized;
    }

    @Override
    public StringCreator insertUpfront(String string) {
        if (string != null) {
            if (charArray == null) {
                charArray = string.toCharArray();
            } else {
                resizeAndInsertUpfront(string);
            }
        }
        return this;
    }

    private void resizeAndInsertUpfront(String string) {
        char[] resized = new char[string.length() + charArray.length];
        for (int i = 0, j = 0; i < resized.length; i++) {
            if (i < string.length()) {
                resized[i] = string.charAt(i);
            } else {
                resized[i] = charArray[j++];
            }
        }
        this.charArray = resized;
    }

    @Override
    public String toString() {
        return new String(charArray);
    }
}
