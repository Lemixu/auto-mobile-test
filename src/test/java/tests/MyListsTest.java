package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class MyListsTest extends CoreTestCase {

    private static final String name_of_folder = "Learning programming";
    private static final String login = "Lemixu";
    private static final String password = "anila3211";


    @Test
    @Features(value={@Feature(value="Search"), @Feature(value="Article"), @Feature(value = "My List")})
    @DisplayName("Save first article")
    @Severity(value= SeverityLevel.CRITICAL)
    public void testSaveFirstArticle() throws InterruptedException {


        SearchPageObject search = SearchPageObjectFactory.get(driver);
        ArticlePageObject article = ArticlePageObjectFactory.get(driver);
        NavigationUI navigate = NavigationUIFactory.get(driver);
        MyListsPageObject lists = MyListPageObjectFactory.get(driver);
        String substring = "Object-oriented programming language";
        String title = "Java (programming language)";

        search.initSearchInput();
        search.typeSearchLine("Java");
        search.clickByArticleWithSubstring(substring);
        article.waitForTitleElement(title);

        String article_title = article.getArticleTitle();
        if (Platform.getInstance().isAndroid()) {
            //String article_title = article.getArticleTitle(title);
            article.addArticleToNewList(name_of_folder);
        } else if (Platform.getInstance().isIOS()) {
            article.addArticlesToMySaved();
            article.closeBannerAfterSaveArticle();
        } else {
            Thread.sleep(1000);
            article.addArticlesToMySaved();
            Thread.sleep(1000);
            AuthorizationPageObject auth = new AuthorizationPageObject(driver);
            auth.clickAuthButton();
            auth.enterLoginData(login, password);
            Thread.sleep(10000);
            auth.submitForm();
            Thread.sleep(5000);
            article.waitForTitleElement(title);

            Assert.assertEquals("We are not in the same page after login",
                    article_title,
                    article.getArticleTitle());
            article.addArticlesToMySaved();
        }


        article.closeArticle();

        if (Platform.getInstance().isAndroid()) {
            navigate.clickBackButton();
        }

        navigate.openNavigation();
        navigate.clickMyLists();

        if (Platform.getInstance().isAndroid()) {
            lists.openArticleByName(name_of_folder);
        }
        lists.swipeArticleToDelete(title);


        }

    }