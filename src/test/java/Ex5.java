import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;


public class Ex5 extends CoreTestCase {

    @Test
    public void testSaveTwoArticles() {
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
        String first_title = article.getArticleTitle(search_input);

        if(Platform.getInstance().isAndroid()) {
            //Сохраняем статью
            article.addArticleToNewList(name_of_folder);
        } else {
            article.addArticlesToMySaved();
            article.closeBannerAfterSaveArticle();
        }
        //Закрываем статью
        article.closeArticle();

        if(Platform.getInstance().isIOS()){
            search.initSearchInput();
        }
        //Переходим во вторую статью
        search.clickByArticleWithSubstring(second_article);
        //Сохраняем заголовок 2-ой статьи
        String second_title = article.getArticleTitle(second_article);

        if (Platform.getInstance().isAndroid()) {
            //Сохраняем статью и переходим в нее
            article.addArticleToOldListAndOpen(name_of_folder);
            lists.waitDownloadListIconDisappear();
        } else {
            article.addArticlesToMySaved();
            article.closeArticle();
            navigate.clickMyLists();
        }

        //Удаляем первую статью
        lists.swipeArticleToDelete(first_title);

        //Убеждаемся, что первая статья удалена
        lists.waitForArticleToDisappearByTitle(first_title);
        //Убеждаемся, что вторая статья осталась
        lists.waitForArticleAppearByTitle(second_article);
        //Переходим во вторую статью
        lists.openArticleByName(second_article);
        String result_title = article.getArticleTitle(second_article);


        assertEquals("The titles are not the same",
                second_title,
                result_title);


    }
}
