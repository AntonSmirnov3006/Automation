package gmail.antonsmirnov3006.selenium.widget;

import org.openqa.selenium.WebElement;

public interface ElementFactory {
  <E extends BaseElement> E create(Class<E> elementClass, WebElement wrappedElement);
}