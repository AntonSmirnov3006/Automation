package gmail.antonsmirnov3006.selenium.widget;


public interface TextInput extends BaseElement {
    void type(String text);

    void clear();

    void clearAndType(String text);
}
