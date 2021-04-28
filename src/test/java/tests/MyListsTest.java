package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class MyListsTest extends CoreTestCase {

    @Test
    public void testSaveFirstArticle(){

        String name_of_folder = "Learning programming";

        SearchPageObject search = new SearchPageObject(driver);
        ArticlePageObject article = new ArticlePageObject(driver);
        NavigationUI navigate = new NavigationUI(driver);
        MyListsPageObject lists = new MyListsPageObject(driver);
        String title = "Java (programming language)";

        search.initClickSkip();
        search.initSearchInput();
        search.typeSearchLine("Java");
        search.clickByArticleWithSubstring(title);
        article.waitForTitleElement(title);

        String article_title = article.getArticleTitle(title);
        article.addArticleToNewList(name_of_folder);
        article.closeArticle();
        navigate.clickBackButton();
        navigate.clickMyLists();
        lists.openFolderByName(name_of_folder);
        lists.swipeArticleToDelete(title);
    }

}
