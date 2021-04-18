import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Ex5 extends Swipe{

    @Test
    public void saveTwoArticles(){
        String text = "Test";
        String search_input = "Java";
        String search_result_locator ="//*[@resource-id=\"org.wikipedia:id/page_list_item_title\"]";

        waitForElementAndClick(
                By.xpath("//androidx.cardview.widget.CardView[@resource-id='org.wikipedia:id/search_container']"),
                "Cannot find search input",
                5);

        //Вводим в строку поиска search_input
        waitForElementAndSenKeys(
                By.xpath("//android.widget.EditText[@resource-id='org.wikipedia:id/search_src_text']"),
                search_input,
                "Cannot find search input",
                5);

        //Переходим в первую статью
        waitForElementAndClick(
                By.xpath(search_result_locator),
                "Cannot find locator '"+search_result_locator +"'",
                15);


        //Сохраняем заголовок 1-ой статьи
        String first_title =waitElementAndGetAttribute(
                By.xpath("(//android.view.View)[3]"),
                "content-desc",
                "Cannot find the title of the article",
                10);


        //Жмем кнопку Save
        waitForElementAndClick(
                By.id("org.wikipedia:id/article_menu_bookmark"),
                "Cannot find button 'Save",
                5);

        //После сохранения добавляем статью в список
        waitForElementAndClick(
                By.id("org.wikipedia:id/snackbar_action"),
                "Cannot find the button 'Add to List",
                5);


        //Вводим название списка
        waitForElementAndSenKeys(
                By.id("org.wikipedia:id/text_input"),
                text,
                "Cannot find text input",
                5);

        //Подтверждаем ввод названия списка
        waitForElementAndClick(
                By.id("android:id/button1"),
                "Cannot find the button 'OK'",
                5);

        //Идем назад к результатам поиска
        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot find the button 'Navigate up'",
                5);

        //Переходим во вторую статью
        waitForElementAndClick(
                By.xpath("("+search_result_locator+")[2]"),
                "Cannot find locator '\"+search_result_locator +\"'\"",
                5);

        //Сохраняем заголовок 2-ой статьи
        String second_title =waitElementAndGetAttribute(
                By.xpath("(//android.view.View)[3]"),
                "content-desc",
                "Cannot find the title of the article",
                10);

        //Сохраняем статью
        waitForElementAndClick(
                By.id("org.wikipedia:id/article_menu_bookmark"),
                "Cannot find button 'Save",
                5);


        waitForElementAndClick(
                By.id("org.wikipedia:id/snackbar_action"),
                "Cannot find the button 'Add to List",
                5);

        //Выбираем существующий список
        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@text='"+text+"']"),
                "Cannot find the lilst named '"+ text +"'",
                5);

        //Переходим в папку со статьями
        waitForElementAndClick(
                By.id("org.wikipedia:id/snackbar_action"),
                "Cannot find the button 'View List'",
                5);

        //Ждем загрузки статьи
        waitForElementNotPresent(
                By.id("org.wikipedia:id/page_list_item_action"),
                "The element 'page_list_item_action' didnt disappear",
                15);

        //Удаляем первую статью
        swipeElementToLeft(
                By.xpath("//android.widget.TextView[@text='"+first_title+"']"),
                "Cannot find the article '"+ first_title+"'");

        //Убеждаемся, что первая статья удалена
        waitForElementNotPresent(
                By.id("//android.widget.TextView[@text='"+first_title+"']"),
                "The element '"+first_title+"'didnt disappear",
                15);


        //Убеждаемся, что вторая статья осталась
        waitForElementPresent(
                By.xpath("//android.widget.TextView[@text='"+second_title+"']"),
                "Cannot find the article '"+second_title+"'");

        //Переходим во вторую статью
        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@text='"+second_title+"']"),
                "Cannot click on article '" +second_title+"'",
                5);

        String result_title = waitElementAndGetAttribute(
                By.xpath("(//android.view.View)[3]"),
                "content-desc",
                "Cannot find the title of the article",
                10);

        Assert.assertEquals("The titles are not the same",
                second_title,
                result_title);


    }
}
