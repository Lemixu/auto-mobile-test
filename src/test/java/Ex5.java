import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;


public class Ex5 extends CoreTestCase {

    private static final String login = "Lemixu";
    private static final String password = "anila3211";


    @Test
    public void testSaveTwoArticles() throws InterruptedException {
        String name_of_folder = "Testik";
        String search_input = "Java";
        String second_article = "Java (programming language)";
        SearchPageObject search = SearchPageObjectFactory.get(driver);
        ArticlePageObject article = ArticlePageObjectFactory.get(driver);
        MyListsPageObject lists = MyListPageObjectFactory.get(driver);
        NavigationUI navigate = NavigationUIFactory.get(driver);


        search.initSearchInput();

        //Вводим в строку поиска search_input
        search.typeSearchLine(search_input);
        //Переходим в первую статью
        search.clickByArticleWithSubstring(search_input);
        //Сохраняем заголовок 1-ой статьи
        String first_title = article.getArticleTitle();

        if(Platform.getInstance().isAndroid()) {
            //Сохраняем статью
            article.addArticleToNewList(name_of_folder);
        } else if(Platform.getInstance().isIOS()){
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
            Thread.sleep(2000);
            article.waitForTitleElement(search_input);

            assertEquals("We are not in the same page after login",
                    search_input,
                    article.getArticleTitle());
            //article.addArticlesToMySaved();
        }

            //Закрываем статью
            article.closeArticle();

        if(Platform.getInstance().isMW()) {
            search.initSearchInput();
            //Вводим в строку поиска search_input
            search.typeSearchLine(search_input);
        }

        if(Platform.getInstance().isIOS()){
            search.initSearchInput();
        }
        //Переходим во вторую статью
        search.clickByArticleWithSubstring(second_article);
        //Сохраняем заголовок 2-ой статьи
        String second_title = article.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            //Сохраняем статью и переходим в нее
            article.addArticleToOldListAndOpen(name_of_folder);
            lists.waitDownloadListIconDisappear();
        } else if(Platform.getInstance().isIOS()){
            article.addArticlesToMySaved();
            article.closeArticle();
            navigate.clickMyLists();
        }
        else {
            Thread.sleep(2000);
            article.addArticlesToMySaved();
            Thread.sleep(2000);
            navigate.openNavigation();
            //Thread.sleep(2000);
            navigate.clickMyLists();
            Thread.sleep(2000);
        }

        //Удаляем первую статью
        lists.swipeArticleToDelete(first_title);
        Thread.sleep(2000);
        //Убеждаемся, что первая статья удалена
        lists.waitForArticleToDisappearByTitle(first_title);
        //Убеждаемся, что вторая статья осталась
        lists.waitForArticleAppearByTitle(second_article);
        //Переходим во вторую статью
        lists.openArticleByName(second_article);
        String result_title = article.getArticleTitle();


        assertEquals("The titles are not the same",
                second_title,
                result_title);


    }
}
