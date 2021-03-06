package ru.yandex.qatools.htmlelements.loader.decorator;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import ru.yandex.qatools.htmlelements.pagefactory.DefaultElementLocator;

import java.lang.reflect.Field;

/**
 * A factory for producing locator instances.
 *
 * @author Alexander Tolmachev starlight@yandex-team.ru
 *         Date: 15.08.12
 */
public class HtmlElementLocatorFactory implements ElementLocatorFactory {
    private final SearchContext searchContext;

    public HtmlElementLocatorFactory(SearchContext searchContext) {
        this.searchContext = searchContext;
    }

    /**
     * Creates locator for the given field. Created locator will process {@link org.openqa.selenium.support.FindBy},
     * {@link org.openqa.selenium.support.FindBys}, {@link ru.yandex.qatools.htmlelements.annotations.Block} and
     * {@link org.openqa.selenium.support.CacheLookup} annotations.
     * @param field Field for which locator will be created.
     */
    @Override
    public ElementLocator createLocator(Field field) {
        return new DefaultElementLocator(searchContext, new HtmlElementFieldAnnotationsHandler(field));
    }
}
