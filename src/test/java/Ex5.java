import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MainPageObject;
import lib.ui.MyListsPageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;


public class Ex5 extends CoreTestCase {

    @Test
    public void testSaveTwoArticles() {
        String name_of_folder = "Testik";
        String search_input = "Java";
        String second_article = "Java (programming language)";
        SearchPageObject search = new SearchPageObject(driver);
        ArticlePageObject article = new ArticlePageObject(driver);
        MyListsPageObject lists = new MyListsPageObject(driver);

        search.initClickSkip();
        search.initSearchInput();

        //Вводим в строку поиска search_input
        search.typeSearchLine(search_input);
        //Переходим в первую статью
        search.clickByArticleWithSubstring(search_input);
        //Сохраняем заголовок 1-ой статьи
        String first_title = article.getArticleTitle(search_input);

        //Сохраняем статью
        article.addArticleToNewList(name_of_folder);
        //Закрываем статью
        article.closeArticle();
        //Переходим во вторую статью
        search.clickByArticleWithSubstring(second_article);
        //Сохраняем заголовок 2-ой статьи
        String second_title = article.getArticleTitle(second_article);

        //Сохраняем статью и переходим в нее
        article.addArticleToOldListAndOpen(name_of_folder);
        lists.waitDownloadListIconDisappear();
        //Удаляем первую статью
        lists.swipeArticleToDelete(first_title);
        //Убеждаемся, что первая статья удалена
        lists.waitForArticleToDisappearByTitle(first_title);
        //Убеждаемся, что вторая статья осталась
        lists.waitForArticleAppearByTitle(second_article);
        //Переходим во вторую статью
        lists.openFolderByName(second_article);
        String result_title = article.getArticleTitle(second_article);


        assertEquals("The titles are not the same",
                second_title,
                result_title);


    }
}
