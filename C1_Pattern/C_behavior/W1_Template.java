package C1_Pattern.C_behavior;

abstract class WebSiteTemplate{
    public void showPage(){
        System.out.println("Header");
        showPageContent();
        System.out.println("Footer");
    }

    abstract void showPageContent();
}


class WelcomPage extends WebSiteTemplate{
    @Override
    void showPageContent() {
        System.out.println("Welcom");
    }
}

class NewPage extends WebSiteTemplate{
    @Override
    void showPageContent() {
        System.out.println("News");
    }
}

//-------------------------------------------------------------------------------
public class W1_Template {
    public static void main(String[] args) {
        WebSiteTemplate welcomPage = new WelcomPage();
        WebSiteTemplate newPage = new NewPage();
            welcomPage.showPage();

        System.out.print("\n=================================================\n");
        newPage.showPage();

    }
}
