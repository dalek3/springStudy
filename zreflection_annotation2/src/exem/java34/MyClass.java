package exem.java34;

public class MyClass {
    @MyTag(myName="오명훈")
    private String name;

    @MyTag
    private String name2;

    public String getName() {
        return name;
    }
    public String getName2() {
        return name2;
    }
}
