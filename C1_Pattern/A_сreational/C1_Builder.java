package C1_Pattern.A_сreational;



enum Cms{WORDPRESS, ALIFRESSO};

class Website {
    private String name;
    private Cms cms;
    private int price;

    public void setName(String name) {
        this.name = name;
    }

    public void setCms(Cms cms) {
        this.cms = cms;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Website{" +
                "name='" + name + '\'' +
                ", cms='" + cms + '\'' +
                ", price=" + price +
                '}';
    }
}

//-------------------------------------------------------------------------------------------
abstract class WebSiteBuilder{
    Website website;

    void createWebsite(){
        website = new Website();
    }

    abstract void buildName();

    abstract void buildCms();

    abstract void buildPrice();

    Website getWebsite(){
        return website;
    }
}



class VisitCardWebsiteBuilder extends WebSiteBuilder{
    @Override
    void buildName() {
        website.setName("Visit card");
    }

    @Override
    void buildCms() {
        website.setCms(Cms.WORDPRESS);
    }

    @Override
    void buildPrice() {
        website.setPrice(500);
    }
}



class EnterpriseWebsiteBuilder extends WebSiteBuilder{
    @Override
    void buildName() {
        website.setName("Enterprice website");
    }

    @Override
    void buildCms() {
        website.setCms(Cms.ALIFRESSO);
    }

    @Override
    void buildPrice() {
        website.setPrice(10_000);
    }
}

//---------------------------------------- Builder ----------------------------------------
class Builder{                                  // в этом классе может реализовывать любую абстракцию WebSiteBuilder
    WebSiteBuilder builder;

    public void setBuilder(WebSiteBuilder builder){
        this.builder = builder;
    }

    Website buildWebsite(){
        builder.createWebsite();
        builder.buildName();
        builder.buildCms();
        builder.buildPrice();
    return builder.getWebsite();
    }
}


//-----------------------------------------------------------------------------------------
public class C1_Builder {
    public static void main(String[] args) {
        Builder builder = new Builder();
            builder.setBuilder(new VisitCardWebsiteBuilder());
            Website website = builder.buildWebsite();
            System.out.println(website);

            builder.setBuilder(new EnterpriseWebsiteBuilder());
            website = builder.buildWebsite();
            System.out.println(website);
    }
}
