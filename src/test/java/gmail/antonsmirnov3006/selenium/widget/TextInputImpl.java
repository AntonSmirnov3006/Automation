package gmail.antonsmirnov3006.selenium.widget;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class TextInputImpl extends AbstractElement implements TextInput {
    public TextInputImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void type(final String text) {
        wait.ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .until(d -> {
                    wrappedElement.sendKeys(text);
                    return true;
                });
    }

    @Override
    public void clear() {
        wrappedElement.sendKeys(Keys.chord(Keys.SHIFT, Keys.UP));
        wrappedElement.sendKeys(Keys.BACK_SPACE);
        wrappedElement.sendKeys(Keys.chord(Keys.SHIFT, Keys.DOWN));
        wrappedElement.sendKeys(Keys.BACK_SPACE);
    }

    @Override
    public void clearAndType(final String text) {
        clear();
        type(text);
    }
}

