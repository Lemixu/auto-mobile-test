package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTest extends CoreTestCase {

    private static final String name_of_folder = "Learning programming";

    @Test
    public void testSaveFirstArticle(){



        SearchPageObject search = SearchPageObjectFactory.get(driver);
        ArticlePageObject article = ArticlePageObjectFactory.get(driver);
        NavigationUI navigate = NavigationUIFactory.get(driver);
        MyListsPageObject lists = MyListPageObjectFactory.get(driver);
        String title = "Java (programming language)";

        search.initSearchInput();
        search.typeSearchLine("Java");
        search.clickByArticleWithSubstring(title);
        article.waitForTitleElement(title);

        if(Platform.getInstance().isAndroid()) {
            String article_title = article.getArticleTitle(title);
            article.addArticleToNewList(name_of_folder);
        }
        else{
            article.addArticlesToMySaved();
            article.closeBannerAfterSaveArticle();
        }

            article.closeArticle();

        if(Platform.getInstance().isAndroid()) {
            navigate.clickBackButton();
        }
            navigate.clickMyLists();

        if (Platform.getInstance().isAndroid()) {
            lists.openArticleByName(name_of_folder);
        }
            lists.swipeArticleToDelete(title);


    }

}
