package C2_SOLID;

// все классы, которые мы создаем, при наследовании не должны затрагивать функциональность и параметры родителей

interface Shaep{
    int getSquare();
}

class Rectangle implements Shaep{
    int with;
    int height;

    @Override
    public int getSquare(){
        return with * height;
    }

    public int getWith() {
        return with;
    }

    public int getHeight() {
        return height;
    }

    public void setWith(int with) {
        this.with = with;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}


class Square implements Shaep{
    int with;

    @Override
    public int getSquare() {
        return with * with;
    }

    public int getWith() {
        return with;
    }

    public void setWith(int with) {
        this.with = with;
    }
}


public class C_LiskovPrinciple {
    static Rectangle getRect(){
        return new Rectangle();
    }

    public static void main(String[] args) {
        Rectangle rectangle = getRect();
            rectangle.setHeight(10);
            rectangle.setWith(5);
        System.out.println(rectangle.getSquare());
    }
}
