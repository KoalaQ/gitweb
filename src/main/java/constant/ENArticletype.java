package constant;

public enum ENArticletype {
    MARKDOWN("1"),
    WORD("2"),
    TXT("3"),
    ADVANCEDTXT("4")
   ;

    private String value;

    private ENArticletype(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
